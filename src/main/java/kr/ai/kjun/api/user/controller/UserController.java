package kr.ai.kjun.api.user.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.user.domain.UserDTO;
import kr.ai.kjun.api.user.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public String save(UserDTO user, Model model) {
        return "";
    }

    @PostMapping("/all")
    public String saveAll(Model model) {
        List<UserDTO> users = new ArrayList<>();

        try {
            // CSV 파일 경로
            String csvFilePath = System.getProperty("user.dir") + "/src/main/resources/static/csv/train.csv";

            System.out.println("🔍 CSV 파일 경로: " + csvFilePath);
            System.out.println("🔍 타이타닉 승객 데이터 읽기 시작...");

            // 파일 존재 여부 확인
            java.io.File csvFile = new java.io.File(csvFilePath);
            if (!csvFile.exists()) {
                System.out.println("❌ CSV 파일이 존재하지 않습니다: " + csvFilePath);
                throw new RuntimeException("CSV 파일을 찾을 수 없습니다: " + csvFilePath);
            }
            System.out.println("✅ CSV 파일 존재 확인 완료");

            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            System.out.println("🔍 CSV 파서 생성 완료");

            // List로 데이터 저장 (상위 5명만)
            int count = 0;
            for (CSVRecord record : parser) {
                if (count >= 5) {
                    break;
                }

                count++;
                System.out.println("📊 승객 " + count + " 데이터 읽는 중...");

                // 각 승객 정보를 DTO에 저장
                UserDTO user = new UserDTO();
                user.setUserId(record.get("PassengerId"));
                user.setSurvived(record.get("Survived"));
                user.setPclass(record.get("Pclass"));
                user.setName(record.get("Name"));
                user.setGender(record.get("Sex"));
                user.setAge(record.get("Age"));
                user.setSibSp(record.get("SibSp"));
                user.setParch(record.get("Parch"));
                user.setTicket(record.get("Ticket"));
                user.setFare(record.get("Fare"));
                user.setCabin(record.get("Cabin"));
                user.setEmbarked(record.get("Embarked"));

                // List에 추가
                users.add(user);

                // 처음 3명의 상세 정보 출력
                if (count <= 3) {
                    System.out.println("📋 승객 " + count + " 정보:");
                    System.out.println("  - ID: " + user.getUserId());
                    System.out.println("  - 생존: " + user.getSurvived());
                    System.out.println("  - 이름: " + user.getName());
                    System.out.println("  - 성별: " + user.getGender());
                    System.out.println("  - 나이: " + user.getAge());
                }
            }

            System.out.println("✅ 총 " + count + "명의 승객 데이터를 읽었습니다.");
            System.out.println("✅ users 리스트 크기: " + users.size());

            parser.close();
            reader.close();

            // UserService를 통해 Repository에 저장하고 콘솔에 출력
            System.out.println("🔄 UserService.saveAll 호출 중...");
            Messenger result = userService.saveAll(users);
            System.out.println("✅ UserService.saveAll 완료");

            // Repository에서 반환된 데이터를 사용 (터미널 출력이 완료된 데이터)
            List<UserDTO> savedUsers = (List<UserDTO>) result.getData();
            System.out.println("🔄 Controller에서 받은 저장된 데이터 크기: " + (savedUsers != null ? savedUsers.size() : "null"));

            model.addAttribute("messenger", result);
            model.addAttribute("users", savedUsers != null ? savedUsers : users);
            return "user/list";

        } catch (Exception e) {
            System.out.println("❌ 오류 발생: " + e.getMessage());
            e.printStackTrace();
            Messenger messenger = new Messenger();
            messenger.setCode(500);
            messenger.setMessage("CSV 파일 읽기 오류: " + e.getMessage());
            model.addAttribute("messenger", messenger);
            model.addAttribute("users", users);
            return "user/list";
        }
    }

    @PutMapping("/{id}")
    public String update(UserDTO user, Model model) {
        Messenger messenger = userService.update(user);
        model.addAttribute("messenger", messenger);
        return "user/list";
    }

    @DeleteMapping("/{id}")
    public String delete(String id, Model model) {
        Messenger messenger = userService.delete(id);
        model.addAttribute("messenger", messenger);
        return "user/list";
    }

    @GetMapping("/id/{id}")
    public String findById(String id, Model model) {
        Messenger messenger = userService.findById(id);
        model.addAttribute("messenger", messenger);
        return "user/list";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        Messenger messenger = userService.findAll();
        model.addAttribute("messenger", messenger);
        return "user/list";
    }
}

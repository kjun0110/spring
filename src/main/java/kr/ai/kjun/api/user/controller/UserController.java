package kr.ai.kjun.api.user.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.PostConstruct;
import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.user.domain.UserDTO;
import kr.ai.kjun.api.user.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostConstruct
    public void init() {
        printFirstFivePassengers();
    }

    @GetMapping("/register")
    @ResponseBody
    public Messenger printFirstFivePassengers() {
        try {
            // CSV 파일 경로
            String csvFilePath = "src/main/resources/static/csv/train.csv";

            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            // List로 데이터 저장
            List<UserDTO> users = new ArrayList<>();

            int count = 0;
            for (CSVRecord record : parser) {
                if (count >= 5) {
                    break;
                }

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
                count++;
            }

            parser.close();
            reader.close();

            // UserService를 통해 Repository에 저장하고 콘솔에 출력
            userService.saveUsers(users);
            userService.printUsers();

            Messenger messenger = new Messenger();
            messenger.setCode(200);
            messenger.setMessage("CSV 파일 읽기 성공");
            return messenger;

        } catch (Exception e) {
            Messenger messenger = new Messenger();
            messenger.setCode(500);
            messenger.setMessage("CSV 파일 읽기 오류");
            return messenger;
        }
    }

}

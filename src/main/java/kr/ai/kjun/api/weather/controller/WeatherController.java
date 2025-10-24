package kr.ai.kjun.api.weather.controller;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.user.domain.UserDTO;
import kr.ai.kjun.api.weather.domain.WeatherDTO;
import kr.ai.kjun.api.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/weathers")
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping("")
    public String save(UserDTO user, Model model) {
        return "";
    }

    @PostMapping("/all")
    public String saveAll(Model model) {
        List<WeatherDTO> weathers = new ArrayList<>(); // 변수를 메서드 시작 부분에서 선언

        try {
            // CSV 파일 경로 (절대 경로 사용)
            String csvFilePath = System.getProperty("user.dir")
                    + "/src/main/resources/static/csv/TRAIN_weather.csv-Grid view.csv";

            System.out.println("🔍 CSV 파일 경로: " + csvFilePath);

            // 파일 존재 여부 확인
            File csvFile = new File(csvFilePath);
            if (!csvFile.exists()) {
                System.out.println("❌ CSV 파일이 존재하지 않습니다: " + csvFilePath);
                throw new RuntimeException("CSV 파일을 찾을 수 없습니다: " + csvFilePath);
            }
            System.out.println("✅ CSV 파일 존재 확인 완료");
            System.out.println("🔍 CSV 파일 읽기 시작...");

            // CSV 파일 읽기 (UTF-8 인코딩 명시)
            FileReader reader = new FileReader(csvFilePath, StandardCharsets.UTF_8);
            CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            System.out.println("🔍 CSV 파서 생성 완료");

            // 모든 데이터를 읽음
            int recordCount = 0;
            for (CSVRecord record : parser) {
                recordCount++;
                System.out.println("📊 레코드 " + recordCount + " 읽는 중...");

                // 각 날씨 정보를 DTO에 저장 (컬럼명으로 접근)
                WeatherDTO weather = new WeatherDTO();
                weather.setDate(record.get("일시")); // 일시
                weather.setAvgTemp(record.get("평균기온(℃)")); // 평균기온(℃)
                weather.setMaxTemp(record.get("최고기온(℃)")); // 최고기온(℃)
                weather.setMaxTempTime(record.get("최고기온시각")); // 최고기온시각
                weather.setMinTemp(record.get("최저기온(℃)")); // 최저기온(℃)
                weather.setMinTempTime(record.get("최저기온시각")); // 최저기온시각
                weather.setTempRange(record.get("일교차")); // 일교차
                weather.setPrecipitation(record.get("강수량(mm)")); // 강수량(mm)

                // List에 추가
                weathers.add(weather);

                // 처음 3개 레코드만 상세 출력
                if (recordCount <= 3) {
                    System.out.println("📋 샘플 데이터 " + recordCount + ":");
                    System.out.println("  - 일시: " + weather.getDate());
                    System.out.println("  - 평균기온: " + weather.getAvgTemp());
                    System.out.println("  - 최고기온: " + weather.getMaxTemp());
                    System.out.println("  - 최저기온: " + weather.getMinTemp());
                    System.out.println("  - 강수량: " + weather.getPrecipitation());
                }
            }

            System.out.println("✅ 총 " + recordCount + "개의 레코드를 읽었습니다.");
            System.out.println("✅ weathers 리스트 크기: " + weathers.size());

            parser.close();
            reader.close();

            // WeatherService를 통해 Repository에 저장
            System.out.println("🔄 WeatherService.saveAll 호출 중...");
            Messenger result = weatherService.saveAll(weathers);
            System.out.println("✅ WeatherService.saveAll 완료");

            // Repository에서 반환된 데이터를 사용 (터미널 출력이 완료된 데이터)
            List<WeatherDTO> savedWeathers = (List<WeatherDTO>) result.getData();
            System.out.println(
                    "🔄 Controller에서 받은 저장된 데이터 크기: " + (savedWeathers != null ? savedWeathers.size() : "null"));

            model.addAttribute("messenger", result);
            model.addAttribute("weathers", savedWeathers != null ? savedWeathers : weathers);
            return "weather/list";

        } catch (Exception e) {
            System.out.println("❌ 오류 발생: " + e.getMessage());
            e.printStackTrace();
            Messenger messenger = new Messenger();
            messenger.setCode(500);
            messenger.setMessage("CSV 파일 읽기 오류: " + e.getMessage());
            model.addAttribute("messenger", messenger);
            model.addAttribute("weathers", weathers);
            return "weather/list";
        }
    }

    @PutMapping("/{id}")
    public String update(WeatherDTO weatherDto, Model model) {
        Messenger messenger = weatherService.update(weatherDto);
        model.addAttribute("messenger", messenger);
        return "weather/list";
    }

    @DeleteMapping("/{id}")
    public String delete(String id, Model model) {
        Messenger messenger = weatherService.delete(id);
        model.addAttribute("messenger", messenger);
        return "weather/list";
    }

    @GetMapping("/id/{id}")
    public String findById(String id, Model model) {
        Messenger messenger = weatherService.findByID(id);
        model.addAttribute("messenger", messenger);
        return "weather/list";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        Messenger messenger = weatherService.findAll();
        model.addAttribute("messenger", messenger);
        return "weather/list";
    }
}

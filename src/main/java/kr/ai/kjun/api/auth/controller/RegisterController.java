package kr.ai.kjun.api.auth.controller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegisterController {

    @GetMapping("/auth/register")
    public void printTop5Passengers() {
        try {
            // CSV 파일 읽기
            ClassPathResource resource = new ClassPathResource("static/csv/train.csv");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));

            // CSV 파싱
            CSVParser csvParser = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim()
                    .parse(reader);

            // List와 Map으로 데이터 저장
            List<Map<String, String>> passengerList = new ArrayList<>();

            int count = 0;
            for (CSVRecord record : csvParser) {
                if (count >= 5) {
                    break;
                }

                // 각 승객 정보를 Map에 저장
                Map<String, String> passengerMap = new HashMap<>();
                passengerMap.put("PassengerId", record.get("PassengerId"));
                passengerMap.put("Survived", record.get("Survived"));
                passengerMap.put("Pclass", record.get("Pclass"));
                passengerMap.put("Name", record.get("Name"));
                passengerMap.put("Sex", record.get("Sex"));
                passengerMap.put("Age", record.get("Age"));
                passengerMap.put("SibSp", record.get("SibSp"));
                passengerMap.put("Parch", record.get("Parch"));
                passengerMap.put("Ticket", record.get("Ticket"));
                passengerMap.put("Fare", record.get("Fare"));
                passengerMap.put("Cabin", record.get("Cabin"));
                passengerMap.put("Embarked", record.get("Embarked"));

                // List에 추가
                passengerList.add(passengerMap);
                count++;
            }

            // 데이터 출력
            System.out.println("================================");
            System.out.println("타이타닉 승객 정보 (상위 5명)");
            System.out.println("List 크기: " + passengerList.size());
            System.out.println("================================");

            for (int i = 0; i < passengerList.size(); i++) {
                Map<String, String> passenger = passengerList.get(i);

                System.out.println("\n[승객 " + (i + 1) + "]");
                System.out.println("PassengerId: " + passenger.get("PassengerId"));
                System.out.println("Survived: " + passenger.get("Survived"));
                System.out.println("Pclass: " + passenger.get("Pclass"));
                System.out.println("Name: " + passenger.get("Name"));
                System.out.println("Sex: " + passenger.get("Sex"));
                System.out.println("Age: " + passenger.get("Age"));
                System.out.println("SibSp: " + passenger.get("SibSp"));
                System.out.println("Parch: " + passenger.get("Parch"));
                System.out.println("Ticket: " + passenger.get("Ticket"));
                System.out.println("Fare: " + passenger.get("Fare"));
                System.out.println("Cabin: " + passenger.get("Cabin"));
                System.out.println("Embarked: " + passenger.get("Embarked"));
            }

            System.out.println("\n================================");
            System.out.println("총 " + passengerList.size() + "명의 정보를 출력했습니다.");
            System.out.println("================================\n");

            csvParser.close();
            reader.close();

        } catch (Exception e) {
            System.err.println("CSV 파일 읽기 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

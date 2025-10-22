package kr.ai.kjun.api.weather.controller;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
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
import kr.ai.kjun.api.weather.domain.WeatherDTO;
import kr.ai.kjun.api.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @PostConstruct
    public void init() {
        readWeatherData();
    }

    @GetMapping("/weather")
    @ResponseBody
    public Messenger readWeatherData() {
        try {
            // CSV 파일 경로
            String csvFilePath = "src/main/resources/static/csv/TRAIN_weather.csv-Grid view.csv";

            // CSV 파일 읽기 (UTF-8 인코딩 명시)
            FileReader reader = new FileReader(csvFilePath, StandardCharsets.UTF_8);
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            // List로 데이터 저장
            List<WeatherDTO> weathers = new ArrayList<>();

            // 모든 데이터를 읽음
            for (CSVRecord record : parser) {
                // 각 날씨 정보를 DTO에 저장 (인덱스로 접근하여 BOM 문제 회피)
                WeatherDTO weather = new WeatherDTO();
                weather.setDate(record.get(0)); // 일시
                weather.setAvgTemp(record.get(1)); // 평균기온(℃)
                weather.setMaxTemp(record.get(2)); // 최고기온(℃)
                weather.setMaxTempTime(record.get(3)); // 최고기온시각
                weather.setMinTemp(record.get(4)); // 최저기온(℃)
                weather.setMinTempTime(record.get(5)); // 최저기온시각
                weather.setTempRange(record.get(6)); // 일교차
                weather.setPrecipitation(record.get(7)); // 강수량(mm)

                // List에 추가
                weathers.add(weather);
            }

            parser.close();
            reader.close();

            // WeatherService를 통해 Repository에 저장하고 콘솔에 출력
            weatherService.saveWeathers(weathers);
            weatherService.printWeathers();

            Messenger messenger = new Messenger();
            messenger.setCode(200);
            messenger.setMessage("CSV 파일 읽기 성공");
            return messenger;

        } catch (Exception e) {
            e.printStackTrace();
            Messenger messenger = new Messenger();
            messenger.setCode(500);
            messenger.setMessage("CSV 파일 읽기 오류: " + e.getMessage());
            return messenger;
        }
    }

}

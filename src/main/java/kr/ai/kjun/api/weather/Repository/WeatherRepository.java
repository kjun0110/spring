package kr.ai.kjun.api.weather.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.weather.domain.WeatherDTO;
import kr.ai.kjun.api.weather.domain.WeatherEntity;

@Repository
public class WeatherRepository {

    private List<WeatherDTO> weatherList = new ArrayList<>();

    public Messenger save(WeatherDTO weather) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Product saved successfully");
        return messenger;
    }

    public Messenger saveAll(List<WeatherDTO> weathers) {
        try {
            System.out.println("🔄 WeatherRepository.saveAll 시작");
            System.out.println("📊 받은 데이터 크기: " + weathers.size());

            // 데이터 저장
            this.weatherList = weathers;
            System.out.println("✅ 데이터 저장 완료");

            // 콘솔에 출력
            System.out.println("🖨️ 터미널 출력 시작...");
            printWeathers();
            System.out.println("✅ 터미널 출력 완료");

            // 성공 메시지 반환 (저장된 데이터 포함)
            Messenger messenger = new Messenger();
            messenger.setCode(200);
            messenger.setMessage("날씨 데이터 저장 및 출력 성공 - 총 " + weathers.size() + "개");
            messenger.setData(weatherList); // 저장된 데이터를 메신저에 포함
            System.out.println("✅ WeatherRepository.saveAll 완료");
            return messenger;

        } catch (Exception e) {
            System.out.println("❌ WeatherRepository에서 오류 발생: " + e.getMessage());
            e.printStackTrace();
            Messenger messenger = new Messenger();
            messenger.setCode(500);
            messenger.setMessage("날씨 데이터 저장 오류: " + e.getMessage());
            return messenger;
        }
    }

    public void printWeathers() {
        System.out.println("================================");
        System.out.println("날씨 정보 (전체)");
        System.out.println("List 크기: " + weatherList.size());
        System.out.println("================================");

        if (weatherList.isEmpty()) {
            System.out.println("⚠️ weatherList가 비어있습니다!");
            return;
        }

        // forEach를 사용하여 배열 출력
        final int[] index = { 1 }; // 날씨 번호를 위한 카운터
        weatherList.forEach(weather -> {
            System.out.println("\n[날씨 데이터 " + index[0] + "]");
            System.out.println("일시: " + (weather.getDate() != null ? weather.getDate() : "null"));
            System.out.println("평균기온(℃): " + (weather.getAvgTemp() != null ? weather.getAvgTemp() : "null"));
            System.out.println("최고기온(℃): " + (weather.getMaxTemp() != null ? weather.getMaxTemp() : "null"));
            System.out.println("최고기온시각: " + (weather.getMaxTempTime() != null ? weather.getMaxTempTime() : "null"));
            System.out.println("최저기온(℃): " + (weather.getMinTemp() != null ? weather.getMinTemp() : "null"));
            System.out.println("최저기온시각: " + (weather.getMinTempTime() != null ? weather.getMinTempTime() : "null"));
            System.out.println("일교차: " + (weather.getTempRange() != null ? weather.getTempRange() : "null"));
            System.out
                    .println("강수량(mm): " + (weather.getPrecipitation() != null ? weather.getPrecipitation() : "null"));
            index[0]++;
        });

        System.out.println("\n================================");
        System.out.println("총 " + weatherList.size() + "개의 날씨 정보를 출력했습니다.");
        System.out.println("================================\n");
    }

    public Messenger login(WeatherEntity WeatherEntity) {
        return null;
    }

    public Messenger update(WeatherDTO weatherDto) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("날씨 데이터 수정 성공");
        return messenger;
    }

    public Messenger delete(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("날씨 데이터 삭제 성공");
        return messenger;
    }

    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("날씨 데이터 조회 성공");
        return messenger;
    }

    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("날씨 데이터 전체 조회 성공");
        return messenger;
    }
}
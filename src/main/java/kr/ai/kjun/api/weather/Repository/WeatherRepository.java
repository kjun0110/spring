package kr.ai.kjun.api.weather.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ai.kjun.api.weather.domain.WeatherDTO;

@Repository
public class WeatherRepository {

    private List<WeatherDTO> weatherList = new ArrayList<>();

    public void saveWeathers(List<WeatherDTO> weathers) {
        this.weatherList = weathers;
    }

    public void printWeathers() {
        System.out.println("================================");
        System.out.println("날씨 정보 (전체)");
        System.out.println("List 크기: " + weatherList.size());
        System.out.println("================================");

        // forEach를 사용하여 배열 출력
        final int[] index = { 1 }; // 날씨 번호를 위한 카운터
        weatherList.forEach(weather -> {
            System.out.println("\n[날씨 데이터 " + index[0] + "]");
            System.out.println("일시: " + weather.getDate());
            System.out.println("평균기온(℃): " + weather.getAvgTemp());
            System.out.println("최고기온(℃): " + weather.getMaxTemp());
            System.out.println("최고기온시각: " + weather.getMaxTempTime());
            System.out.println("최저기온(℃): " + weather.getMinTemp());
            System.out.println("최저기온시각: " + weather.getMinTempTime());
            System.out.println("일교차: " + weather.getTempRange());
            System.out.println("강수량(mm): " + weather.getPrecipitation());
            index[0]++;
        });

        System.out.println("\n================================");
        System.out.println("총 " + weatherList.size() + "개의 날씨 정보를 출력했습니다.");
        System.out.println("================================\n");
    }

}

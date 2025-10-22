package kr.ai.kjun.api.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {

    private String date; // 일시
    private String avgTemp; // 평균기온(℃)
    private String maxTemp; // 최고기온(℃)
    private String maxTempTime; // 최고기온시각
    private String minTemp; // 최저기온(℃)
    private String minTempTime; // 최저기온시각
    private String tempRange; // 일교차
    private String precipitation; // 강수량(mm)

}

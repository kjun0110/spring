package kr.ai.kjun.api.weather.service;

import java.util.List;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.weather.domain.WeatherDTO;

public interface WeatherService {

    public Messenger saveAll(List<WeatherDTO> weathers);
    public Messenger save(WeatherDTO weatherDto);
    public Messenger update(WeatherDTO weatherDto);
    public Messenger delete(String id);
    public Messenger findByID(String id);
    public Messenger findAll();
}

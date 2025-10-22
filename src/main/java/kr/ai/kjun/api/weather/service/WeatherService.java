package kr.ai.kjun.api.weather.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.weather.Repository.WeatherRepository;
import kr.ai.kjun.api.weather.domain.WeatherDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public void saveWeathers(List<WeatherDTO> weathers) {
        weatherRepository.saveWeathers(weathers);
    }

    public void printWeathers() {
        weatherRepository.printWeathers();
    }
}

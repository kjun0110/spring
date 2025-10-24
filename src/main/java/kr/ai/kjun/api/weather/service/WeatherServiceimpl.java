package kr.ai.kjun.api.weather.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.weather.Repository.WeatherRepository;
import kr.ai.kjun.api.weather.domain.WeatherDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherServiceimpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    @Override
    public Messenger save(WeatherDTO weatherDto) {
        return weatherRepository.save(weatherDto);
    }

    @Override
    public Messenger update(WeatherDTO weatherDto) {
        return weatherRepository.update(weatherDto);
    }

    @Override
    public Messenger delete(String id) {
        return weatherRepository.delete(id);
    }

    @Override
    public Messenger findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public Messenger saveAll(List<WeatherDTO> weathers) {
        return weatherRepository.saveAll(weathers);
    }

    @Override
    public Messenger findByID(String id) {
        return weatherRepository.findById(id);
    }

}

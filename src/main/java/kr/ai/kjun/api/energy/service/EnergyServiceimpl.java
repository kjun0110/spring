package kr.ai.kjun.api.energy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.energy.domain.EnergyDTO;
import kr.ai.kjun.api.energy.repository.EnergyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnergyServiceimpl implements EnergyService {
    private final EnergyRepository energydataRepository;

    @Override
    public Messenger save(EnergyDTO energy) {
        return energydataRepository.save(energy);
    }

    @Override
    public Messenger saveAll(List<EnergyDTO> energys) {
        return energydataRepository.saveAll(energys);
    }

    @Override
    public Messenger update(EnergyDTO energy) {
        return energydataRepository.update(energy);
    }

    @Override
    public Messenger delete(String corporate) {
        return energydataRepository.delete(corporate);
    }

    @Override
    public Messenger findById(String corporate) {
       return energydataRepository.findById(corporate);
    }

    @Override
    public Messenger findAll() {
        return energydataRepository.findAll();
    }

}

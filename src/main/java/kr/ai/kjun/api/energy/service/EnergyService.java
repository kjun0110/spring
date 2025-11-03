package kr.ai.kjun.api.energy.service;

import java.util.List;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.energy.domain.EnergyDTO;

public interface EnergyService {
    Messenger save(EnergyDTO energy);
    Messenger saveAll(List<EnergyDTO> energys);
    Messenger update(EnergyDTO energy);
    Messenger delete(String coperate);
    Messenger findById(String corporate);
    Messenger findAll();   
}

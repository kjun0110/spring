package kr.ai.kjun.api.energy.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.energy.domain.EnergyDTO;

@Repository
public class EnergyRepository {


    public Messenger save(EnergyDTO energy) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("EnergyData saved successfully");
        return messenger;
    }

    public Messenger saveAll(List<EnergyDTO> energys) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("EnergyData saved successfully");
        return messenger;
    }

    public Messenger update(EnergyDTO energy) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("EnergyData updated successfully");
        return messenger;
    }


    public Messenger delete(String corporate) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("EnergyData deleted successfully");
        return messenger;
    }


    public Messenger findById(String corporate) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("EnergyData found successfully");
        return messenger;
    }


    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("EnergyData found successfully");
        return messenger;
    }



}

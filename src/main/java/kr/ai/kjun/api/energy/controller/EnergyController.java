package kr.ai.kjun.api.energy.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.energy.domain.EnergyDTO;
import kr.ai.kjun.api.energy.service.EnergyService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/energys")
public class EnergyController {
    private final EnergyService energyService;

    @PostMapping("")
    public String save(EnergyDTO energy, Model model) {
        Messenger messenger = energyService.save(energy);
        model.addAttribute("messenger", messenger);
        return "energy/save";
    }

    @PostMapping("/all")
    public String saveAll(List<EnergyDTO> energys, Model model) {
        Messenger messenger = energyService.saveAll(energys);
        model.addAttribute("messenger", messenger);
        return "energy/list";
    }

    @PutMapping("/{id}")
    public String update(EnergyDTO energy, Model model) {
        Messenger messenger = energyService.update(energy);
        model.addAttribute("messenger", messenger);
        return "energy/detail";
    }

    @DeleteMapping("/{id}")
    public String delete(String corporate, Model model) {
        Messenger messenger = energyService.delete(corporate);
        model.addAttribute("messenger", messenger);
        return "energy/list";
    }

    @GetMapping("/{id}")
    public String findById(String corporate, Model model) {
        Messenger messenger = energyService.findById(corporate);
        model.addAttribute("messenger", messenger);
        return "energy/detail";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        Messenger messenger = energyService.findAll();
        model.addAttribute("messenger", messenger);
        return "energy/list";
    }
}

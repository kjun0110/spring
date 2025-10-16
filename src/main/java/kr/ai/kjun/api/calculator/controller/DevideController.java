package kr.ai.kjun.api.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ai.kjun.api.calculator.domain.DevideDTO;
import kr.ai.kjun.api.calculator.service.DevideService;

@Controller
public class DevideController {

    private final DevideService devideService;

    public DevideController(DevideService devideService) {
        this.devideService = devideService;
    }
    
    @PostMapping("/calculator/devide")
    public String devide(
            @RequestParam(name = "number1") int number1,
            @RequestParam(name = "number2") int number2) {
        
        // 콘솔에 출력
        System.out.println("=== 나눗셈 계산 요청 ===");
        System.out.println("첫 번째 숫자: " + number1);
        System.out.println("두 번째 숫자: " + number2);
        
        if (number2 != 0) {
            System.out.println("결과: " + ((double) number1 / number2));
        } else {
            System.out.println("0으로 나눌 수 없습니다!");
        }
        System.out.println("=====================");
        
        DevideDTO devideDTO = new DevideDTO();
        devideDTO.setNumber1(number1);
        devideDTO.setNumber2(number2);
        
        devideService.devide(devideDTO);

        // 계산 페이지로 다시 돌아가기
        return "calculator/devide";
    }
}


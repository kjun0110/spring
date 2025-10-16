package kr.ai.kjun.api.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ai.kjun.api.calculator.domain.MinusDTO;
import kr.ai.kjun.api.calculator.service.MinusService;

@Controller
public class MinusController {

    private final MinusService minusService;

    public MinusController(MinusService minusService) {
        this.minusService = minusService;
    }
    
    @GetMapping("/calculator/minus")
    public String minus(
            @RequestParam(name = "number1") int number1,
            @RequestParam(name = "number2") int number2) {
        
        // 콘솔에 출력
        System.out.println("=== 뺄셈 계산 요청 ===");
        System.out.println("첫 번째 숫자: " + number1);
        System.out.println("두 번째 숫자: " + number2);
        System.out.println("결과: " + (number1 - number2));
        System.out.println("=====================");
        
        MinusDTO minusDTO = new MinusDTO();
        minusDTO.setNumber1(number1);
        minusDTO.setNumber2(number2);
        
        minusService.minus(minusDTO);

        // 계산 페이지로 다시 돌아가기
        return "calculator/minus";
    }
}


package kr.ai.kjun.api.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ai.kjun.api.calculator.domain.PlusDTO;
import kr.ai.kjun.api.calculator.service.PlusService;

@Controller
public class PlusController {

    private final PlusService plusService;

    public PlusController(PlusService plusService) {
        this.plusService = plusService;
    }
    
    @GetMapping("/calculator/plus")
    public String plus(
            @RequestParam(name = "number1") int number1,
            @RequestParam(name = "number2") int number2) {
        
        // 콘솔에 출력
        System.out.println("=== 덧셈 계산 요청 ===");
        System.out.println("첫 번째 숫자: " + number1);
        System.out.println("두 번째 숫자: " + number2);
        System.out.println("결과: " + (number1 + number2));
        System.out.println("=====================");
        PlusDTO plusDTO = new PlusDTO();
        plusDTO.setNumber1(number1);
        plusDTO.setNumber2(number2);
        
        plusService.plus(plusDTO);

        // 계산 페이지로 다시 돌아가기
        return "calculator/plus";
    }
}

package kr.ai.kjun.api.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ai.kjun.api.calculator.domain.TimesDTO;
import kr.ai.kjun.api.calculator.service.TimesService;

@Controller
public class TimesController {

    private final TimesService timesService;

    public TimesController(TimesService timesService) {
        this.timesService = timesService;
    }
    
    @PostMapping("/calculator/times")
    public String times(
            @RequestParam(name = "number1") int number1,
            @RequestParam(name = "number2") int number2) {
        
        // 콘솔에 출력
        System.out.println("=== 곱셈 계산 요청 ===");
        System.out.println("첫 번째 숫자: " + number1);
        System.out.println("두 번째 숫자: " + number2);
        System.out.println("결과: " + (number1 * number2));
        System.out.println("=====================");
        
        TimesDTO timesDTO = new TimesDTO();
        timesDTO.setNumber1(number1);
        timesDTO.setNumber2(number2);
        
        timesService.times(timesDTO);

        // 계산 페이지로 다시 돌아가기
        return "calculator/times";
    }
}


package kr.ai.kjun.api.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ai.kjun.api.calculator.domain.CalculatorDTO;
import kr.ai.kjun.api.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator/calculator")
    public String calculator(
            @RequestParam(name = "number1", required = false) Double number1,
            @RequestParam(name = "number2", required = false) Double number2,
            @RequestParam(name = "opcode", required = false) String opcode) {

        // 파라미터가 없으면 그냥 페이지만 반환
        if (number1 == null || number2 == null || opcode == null) {
            return "calculator/calculator";
        }

        // DTO 생성 및 서비스 호출
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setNumber1(number1);
        calculatorDTO.setNumber2(number2);
        calculatorDTO.setOpcode(opcode);

        // 서비스에서 결과 받기
        double result = calculatorService.calculator(calculatorDTO);
        String opcodeName = "";
        if (opcode.equals("+")) {
            opcodeName = "덧셈";
        } else if (opcode.equals("-")) {
            opcodeName = "뺄셈";
        } else if (opcode.equals("*")) {
            opcodeName = "곱셈";
        } else if (opcode.equals("/")) {
            opcodeName = "나눗셈";
        } else {
            opcodeName = "연산자오류";
        }

        // 콘솔에 출력
        System.out.println("=== 통합 계산기 컨트롤러 ===");
        System.out.println("연산: " + opcodeName);
        System.out.println("첫 번째 숫자: " + number1);
        System.out.println("연산자: " + opcode);
        System.out.println("두 번째 숫자: " + number2);
        System.out.println("서비스에서 받은 결과: " + result);
        System.out.println("==============================");

        return "calculator/calculator";
    }
}

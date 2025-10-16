package kr.ai.kjun.api.calculator.service;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.calculator.domain.CalculatorDTO;

@Service
public class CalculatorService {

    public double calculator(CalculatorDTO calculatorDTO) {
        System.out.println("계산기 서비스로 들어옴");
        System.out.println("서비스로 전달된 첫번째 숫자: " + calculatorDTO.getNumber1());
        System.out.println("서비스로 전달된 두번째 숫자: " + calculatorDTO.getNumber2());
        System.out.println("서비스로 전달된 연산자: " + calculatorDTO.getOpcode());

        String opcodeName = "";
        double result = 0;

        if (calculatorDTO.getOpcode().equals("+")) {
            opcodeName = "덧셈";
            result = calculatorDTO.getNumber1() + calculatorDTO.getNumber2();
        } else if (calculatorDTO.getOpcode().equals("-")) {
            opcodeName = "뺄셈";
            result = calculatorDTO.getNumber1() - calculatorDTO.getNumber2();
        } else if (calculatorDTO.getOpcode().equals("*")) {
            opcodeName = "곱셈";
            result = calculatorDTO.getNumber1() * calculatorDTO.getNumber2();
        } else if (calculatorDTO.getOpcode().equals("/")) {
            opcodeName = "나눗셈";
            if (calculatorDTO.getNumber2() != 0) {
                result = calculatorDTO.getNumber1() / calculatorDTO.getNumber2();
            }
        } else {
            opcodeName = "연산자오류";
        }

        System.out.println("연산: " + opcodeName + ", 결과: " + result);

        return result;
    }
}
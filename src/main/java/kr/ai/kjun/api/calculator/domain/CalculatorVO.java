package kr.ai.kjun.api.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorVO {
    private double number1;
    private String opcode;
    private double number2;
}

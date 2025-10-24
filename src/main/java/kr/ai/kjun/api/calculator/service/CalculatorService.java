package kr.ai.kjun.api.calculator.service;

import kr.ai.kjun.api.calculator.domain.CalculatorDTO;

public interface CalculatorService {

    public int add (CalculatorDTO calculatorDTO);
    public int subtract (CalculatorDTO calculatorDTO);
    public int multiply (CalculatorDTO calculatorDTO);
    public int divide (CalculatorDTO calculatorDTO);


    }

package kr.ai.kjun.api.calculator.repository;


import org.springframework.stereotype.Repository;

import kr.ai.kjun.api.calculator.domain.CalculatorDTO;
import kr.ai.kjun.api.calculator.service.CalculatorService;

@Repository
public class CalculatorRepositoryImpl implements CalculatorService {

    @Override
    public int add(CalculatorDTO calculatorDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int subtract(CalculatorDTO calculatorDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subtract'");
    }

    @Override
    public int multiply(CalculatorDTO calculatorDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multiply'");
    }

    @Override
    public int divide(CalculatorDTO calculatorDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'divide'");
    }


}

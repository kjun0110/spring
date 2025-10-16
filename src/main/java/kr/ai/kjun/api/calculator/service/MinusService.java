package kr.ai.kjun.api.calculator.service;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.calculator.domain.MinusDTO;

@Service
public class MinusService {
    
    public int minus(MinusDTO minusDTO) {
        System.out.println("빼기 서비스로 들어옴");
        System.out.println("서비스로 전달된 첫번째 숫자: " + minusDTO.getNumber1());
        System.out.println("서비스로 전달된 두번째 숫자: " + minusDTO.getNumber2());
        System.out.println("서비스로 전달된 결과: " + (minusDTO.getNumber1() - minusDTO.getNumber2()));
        
        return minusDTO.getNumber1() - minusDTO.getNumber2();
    }

}


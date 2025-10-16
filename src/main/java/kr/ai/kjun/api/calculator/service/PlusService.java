package kr.ai.kjun.api.calculator.service;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.calculator.domain.PlusDTO;

@Service
public class PlusService {
    
    public int plus(PlusDTO plusDTO) {
        System.out.println("더하기 서비스로 들어옴");
        System.out.println("서비스로 전달된 첫번째 숫자: " + plusDTO.getNumber1());
        System.out.println("서비스로 전달된 두번째 숫자: " + plusDTO.getNumber2());
        System.out.println("서비스로 전달된 결과: " + (plusDTO.getNumber1() + plusDTO.getNumber2()));
        
        return plusDTO.getNumber1() + plusDTO.getNumber2();
    }

}

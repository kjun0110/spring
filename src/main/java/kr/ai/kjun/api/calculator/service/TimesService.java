package kr.ai.kjun.api.calculator.service;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.calculator.domain.TimesDTO;

@Service
public class TimesService {
    
    public int times(TimesDTO timesDTO) {
        System.out.println("곱하기 서비스로 들어옴");
        System.out.println("서비스로 전달된 첫번째 숫자: " + timesDTO.getNumber1());
        System.out.println("서비스로 전달된 두번째 숫자: " + timesDTO.getNumber2());
        System.out.println("서비스로 전달된 결과: " + (timesDTO.getNumber1() * timesDTO.getNumber2()));
        
        return timesDTO.getNumber1() * timesDTO.getNumber2();
    }

}


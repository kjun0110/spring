package kr.ai.kjun.api.calculator.service;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.calculator.domain.DevideDTO;

@Service
public class DevideService {
    
    public double devide(DevideDTO devideDTO) {
        System.out.println("나누기 서비스로 들어옴");
        System.out.println("서비스로 전달된 첫번째 숫자: " + devideDTO.getNumber1());
        System.out.println("서비스로 전달된 두번째 숫자: " + devideDTO.getNumber2());
        
        if (devideDTO.getNumber2() == 0) {
            System.out.println("0으로 나눌 수 없습니다!");
            return 0;
        }
        
        double result = (double) devideDTO.getNumber1() / devideDTO.getNumber2();
        System.out.println("서비스로 전달된 결과: " + result);
        
        return result;
    }

}


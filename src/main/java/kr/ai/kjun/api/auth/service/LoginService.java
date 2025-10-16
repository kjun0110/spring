package kr.ai.kjun.api.auth.service;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.auth.domain.LoginDTO;
import kr.ai.kjun.api.auth.domain.LoginVO;
import kr.ai.kjun.api.common.domain.Messenger;

@Service
public class LoginService {

    public Messenger login(LoginDTO loginDTO) {
        System.out.println("로그인 서비스로 들어옴");
        System.out.println("DTO서비스로 전달된 이메일 : " + loginDTO.getEmail());
        System.out.println("DTO서비스로 전달된 비밀번호 : " + loginDTO.getPassword());

        LoginVO loginVO = new LoginVO();
        System.out.println("VO서비스로 전달된 이메일 : " + loginVO.getEmail());
        System.out.println("VO서비스로 전달된 비밀번호 : " + loginVO.getPassword());

        int code = 0;
        String message = "";

        if (loginVO.getEmail().equals(loginDTO.getEmail())
                && loginVO.getPassword().equals(loginDTO.getPassword())) {
            code = 0;
            message = "로그인성공";
        }
        else if (loginVO.getEmail().equals((loginDTO.getEmail()))
                && !loginVO.getPassword().equals(loginDTO.getPassword())) {
            code = 2;
            message = "비밀번호 불일치";
        }
        else {
            code = 1;
            message = "이메일 불일치";
        }

        Messenger messenger = new Messenger();
        messenger.setCode(code);
        messenger.setMessage(message);
        return messenger;
    }
}

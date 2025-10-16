package kr.ai.kjun.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ai.kjun.api.auth.domain.LoginDTO;
import kr.ai.kjun.api.auth.service.LoginService;

@Controller
public class LoginController {

    private final LoginService loginService;
    
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    // form값과 같게 만듦
    @GetMapping("/auth/login")   
    public String login(
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "password", required = false) String password) {
        
        // 콘솔에 출력
        System.out.println("컨트롤러로 들어옴옴");
        System.out.println("화면에서 컨트롤러로 들어온 이메일: " + email);
        System.out.println("화면에서 컨트롤러로 들어온 비밀번호: " + password);
        System.out.println("==================");
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(email);
        loginDTO.setPassword(password);
        
        loginService.login(loginDTO);

        
        // 로그인 페이지 반환
        return "auth/login";
    }
} 

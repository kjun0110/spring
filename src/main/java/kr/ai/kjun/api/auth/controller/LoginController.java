package kr.ai.kjun.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    // form값과 같게 만듦
    @GetMapping("/auth/login")   
    public String login(
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "password", required = false) String password) {
        
        // 콘솔에 출력
        System.out.println("=== 로그인 요청 ===");
        System.out.println("이메일: " + email);
        System.out.println("비밀번호: " + password);
        System.out.println("==================");
        
        // 로그인 페이지 반환
        return "auth/login";
    }
} 

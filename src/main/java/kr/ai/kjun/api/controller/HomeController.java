package kr.ai.kjun.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }
    
    @GetMapping("/find-account")
    public String findAccount() {
        return "auth/find-account";
    }
    
    @GetMapping("/calculator/plus")
    public String plus() {
        return "contents/calculator/plus";
    }

    @GetMapping("/calculator/minus")
    public String minus() {
        return "contents/calculator/minus";
    }

    @GetMapping("/contents/calculator/times")
    public String times() {
        return "contents/calculator/times";
    }

    @GetMapping("/contents/calculator/devide")
    public String devide() {
        return "contents/calculator/devide";
    }
}

package kr.ai.kjun.api.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/auth/login.html")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/move/auth/register")
    public String register() {
        return "auth/register";
    }

    @GetMapping("/move/auth/find-account")
    public String findAccount() {
        return "auth/find-account";
    }

    @GetMapping("/calculator/plus.html")
    public String plus() {
        return "calculator/plus";
    }

    @GetMapping("/calculator/minus.html")
    public String minus() {
        return "calculator/minus";
    }

    @GetMapping("/calculator/times.html")
    public String times() {
        return "calculator/times";
    }

    @GetMapping("/calculator/devide.html")
    public String devide() {
        return "calculator/devide";
    }

    @GetMapping("/calculator/calculator.html")
    public String calculator() {
        return "calculator/calculator";
    }
}

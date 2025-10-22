package kr.ai.kjun.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import kr.ai.kjun.api.auth.domain.LoginDTO;
import kr.ai.kjun.api.auth.service.LoginService;
import kr.ai.kjun.api.common.domain.Messenger;

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
            @RequestParam(name = "password", required = false) String password, Model model) {

        // 콘솔에 출력
        System.out.println("컨트롤러로 들어옴옴");
        System.out.println("화면에서 컨트롤러로 들어온 이메일: " + email);
        System.out.println("화면에서 컨트롤러로 들어온 비밀번호: " + password);
        System.out.println("==================");

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        Messenger messenger = loginService.login(loginDTO);

        System.out.println("서비스에서 컨트롤러로 리턴된 코드: " + messenger.getCode());
        System.out.println("서비스에서 컨트롤러로 리턴된 메시지: " + messenger.getMessage());

        model.addAttribute("messenger", messenger);

        return "auth/login";
    }
}

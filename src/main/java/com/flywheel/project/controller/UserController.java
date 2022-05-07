package com.flywheel.project.controller;

import com.flywheel.project.dto.UserDto;
import com.flywheel.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    /**
     * 메인페이지 이동
     *
     * @return
     */
    @GetMapping("/")
    public String main() {
        return "index";
    }

    /**
     * 로그인 페이지 이동
     *
     * @return
     */
    @GetMapping("/user/login")
    public String goLogin() {
        return "user/login";
    }

    /**
     * 로그인 에러
     *
     * @param model
     * @return
     */
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);

        return "/user/login";
    }

    /**
     * 회원가입 페이지 이동
     *
     * @return
     */
    @GetMapping("/signup")
    public String goSignup(Model model) {
        model.addAttribute("user", new UserDto());
        return "user/signup";
    }

    /**
     * 회원가입 처리
     *
     * @param userDto
     * @return
     */
    @PostMapping("/signup")
    public String signup(UserDto userDto) {
        userService.joinUser(userDto);

        return "redirect:/user/login";
    }

    /**
     * 접근 거부 페이지 이동
     *
     * @return
     */
    @GetMapping("/denied")
    public String doDenied() {
        return "user/denied";
    }

    /**
     * 내 정보 페이지 이동
     *
     * @return
     */
    @GetMapping("/info")
    public String goMyInfo() {
        return "user/myinfo";
    }

    /**
     * Admin 페이지 이동
     *
     * @return
     */
    @GetMapping("/admin")
    public String goAdmin() {
        return "user/admin";
    }
}

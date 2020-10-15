package com.example.hospital.controller;

import com.example.hospital.entity.Role;
import com.example.hospital.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class SignController {
    private final SignService signService;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/registration")
    public ModelAndView getRegisterPage() {
        return new ModelAndView("register");
    }

    @PostMapping("/registration")
    public ModelAndView login(@RequestParam String name, @RequestParam String surname,
                              @RequestParam String birthday, @RequestParam String email,
                              @RequestParam String password, @RequestParam String role) {

        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password) || StringUtils.isEmpty(email)) {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.getModelMap().addAttribute("errorMessage", "fill.form");
            return modelAndView;
        }

        signService.signUp(name,surname, LocalDate.parse(birthday), email, password, Role.valueOf(role));

        return new ModelAndView("login");
    }
}

package com.zljin.gulimall.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping({"/","/login.html"})
    public String loginPage(HttpSession session){
        return "login";
    }
}

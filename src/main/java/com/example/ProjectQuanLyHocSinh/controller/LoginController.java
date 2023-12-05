package com.example.ProjectQuanLyHocSinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login";
    }
    @GetMapping("/showPage403")
    public String showPage403(){
        return "error/403";
    }
    @GetMapping("/showPage404")
    public String showPage404(){
        return "error/404";
    }
}

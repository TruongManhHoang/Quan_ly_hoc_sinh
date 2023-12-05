package com.example.ProjectQuanLyHocSinh.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @GetMapping()
    public String showHomePage(Model model){
        return "teacher/home";
    }
}

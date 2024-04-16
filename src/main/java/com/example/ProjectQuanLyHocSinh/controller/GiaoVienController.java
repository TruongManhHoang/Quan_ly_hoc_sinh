package com.example.ProjectQuanLyHocSinh.controller;


import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import com.example.ProjectQuanLyHocSinh.service.GiaoVien.GiaoVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/giaoVien")
public class GiaoVienController {
    private GiaoVienService giaoVienService;

    @Autowired
    public GiaoVienController(GiaoVienService giaoVienService) {
        this.giaoVienService = giaoVienService;
    }

    @GetMapping()
    public String showHomePage(Model model){
        return "/giaoVien/home";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<GiaoVien> giaoVien = giaoVienService.findAll();
        model.addAttribute("giaoVien", giaoVien);
        return "/giaoVien/show";
    }
    @GetMapping("/create")
    public String create(Model model){
        GiaoVien giaoVien = new GiaoVien();
        model.addAttribute("giaoVien", giaoVien);
        return "/giaoVien/insert";
    }
    @PostMapping("/saveGiaoVien")
    public String save(@ModelAttribute("giaoVien") GiaoVien giaoVien){
        giaoVienService.save(giaoVien);
        return "redirect:/giaoVien/list";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable( value = "id" ) Integer id, Model model){
        GiaoVien giaoVien = giaoVienService.findById(id);
        model.addAttribute("giaoVien", giaoVien);
        return "/giaoVien/update";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id){
        giaoVienService.delete(id);
        return "redirect:/giaoVien/list";
    }

}

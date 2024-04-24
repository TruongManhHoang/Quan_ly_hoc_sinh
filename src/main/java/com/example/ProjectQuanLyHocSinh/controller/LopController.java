package com.example.ProjectQuanLyHocSinh.controller;

import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;
import com.example.ProjectQuanLyHocSinh.service.Lop.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lop")
public class LopController {
    private LopService lopService;

    @Autowired
    public LopController(LopService lopService) {
        this.lopService = lopService;
    }
    @GetMapping("/list")
    public String list(Model model){
        List<Lop> lop = lopService.findAll();
        model.addAttribute("lop", lop);
        return "/Lop/show";
    }
    @GetMapping("/create")
    public String create(Model model){
        Lop lop = new Lop();
        model.addAttribute("lop", lop);
        return "/lop/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("lop") Lop lop, Model model){
        lopService.save(lop);
        return "redirect:/lop/list";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable( value = "id") Integer id, Model model){
        Lop lop = lopService.findById(id);
        model.addAttribute("lop", lop);
        return "/lop/update";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable( value = "id") Integer id){
        lopService.delete(id);
        return "redirect:/lop/list";
    }
}

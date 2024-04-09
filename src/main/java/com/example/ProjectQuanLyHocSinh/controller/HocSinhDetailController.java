package com.example.ProjectQuanLyHocSinh.controller;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinhDetail;
import com.example.ProjectQuanLyHocSinh.service.hocsinh.HocSinhDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hocSinhDetail")
public class HocSinhDetailController {
    private HocSinhDetailService hocSinhDetailService;

    @Autowired
    public HocSinhDetailController(HocSinhDetailService hocSinhDetailService) {
        this.hocSinhDetailService = hocSinhDetailService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<HocSinhDetail> hocSinhDetail = hocSinhDetailService.findAll();
        model.addAttribute("hocSinhDetail", hocSinhDetail);
        return "/hocSinhDetail/show";
    }
    @GetMapping("/create")
    public String create(Model model){
        HocSinhDetail hocSinhDetail = new HocSinhDetail();
        model.addAttribute("hocSinhDetail",hocSinhDetail);
        return "/hocSinhDetail/insert";
    }
    @PostMapping("/saveHocSinhDetail")
    public String save(@ModelAttribute("HocSinhDetail") HocSinhDetail hocSinhDetail){
        hocSinhDetailService.save(hocSinhDetail);
        return "redirect:/hocSinhDetail/list";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model){
        HocSinhDetail hocSinhDetail = hocSinhDetailService.findById(id);
        model.addAttribute("hocSinhDetail",hocSinhDetail);
        return "/hocSinhDetail/update";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable( value = "id") Integer id){
        hocSinhDetailService.delete(id);
        return "redirect:/hocSinhDetail/list";
    }
}

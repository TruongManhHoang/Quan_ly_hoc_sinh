package com.example.ProjectQuanLyHocSinh.controller;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import com.example.ProjectQuanLyHocSinh.service.hocsinh.HocSinhService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/hocSinh")
public class HocSinhController {
    private HocSinhService hocSinhService;

    @Autowired
    public HocSinhController(HocSinhService hocSinhService) {
        this.hocSinhService = hocSinhService;
    }
    @GetMapping()
    public String showHomePage(Model model){
        return "hocsinh/hocSinh";
    }

    @GetMapping("/create")
    public String create(Model model){
        HocSinh hocSinh = new HocSinh();
        model.addAttribute("hocsinh",hocSinh);
        return "/hocsinh/insert";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("hocsinh") HocSinh hocSinh, HttpServletRequest request){
        hocSinhService.save(hocSinh);
        return "redirect:/hocSinh/list";
    }
    @GetMapping("/list")
    public String listAll(Model model){
        List<HocSinh> hocSinhs = hocSinhService.findAll();
        model.addAttribute("hocsinh", hocSinhs);
        return "/hocsinh/show";
    }
    // display image
//    @GetMapping("/display")
//    public ResponseEntity<byte[]> displayImage(@RequestParam("id") Integer id) throws IOException, SQLException
//    {
//        HocSinh hocSinh = hocSinhService.findById(id);
//        byte [] imageBytes = null;
//        imageBytes = hocSinh.getAvatar().getBytes(1,(int) hocSinh.getAvatar().length());
//        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
//    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model){
        HocSinh hocSinh = hocSinhService.findById(id);
        model.addAttribute("hocsinh",hocSinh);
        return "/hocsinh/update";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable( value = "id") Integer id){
        hocSinhService.delete(id);
        return "redirect:/hocSinh/list";
    }
}

package com.example.ProjectQuanLyHocSinh.controller;

import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Users;
import com.example.ProjectQuanLyHocSinh.service.TaiKhoan.UserService;
import com.example.ProjectQuanLyHocSinh.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model model){
        RegisterUser registerUser = new RegisterUser();
        model.addAttribute("registerUser",registerUser);
        return "register/form";
    }
    @PostMapping("/process")
    public String process(@Valid @ModelAttribute RegisterUser registerUser,
                          Model model, BindingResult result, HttpSession session){
        String username = registerUser.getUsername();
        // check form validation
        if(result.hasErrors()){
            return "register/form";
        }
        // kiem tra user da ton tai
        List<Users> users = userService.findByUserName(username);
        if(users != null){
            model.addAttribute("registerUser",new RegisterUser());
            model.addAttribute("error","Tài khoản đã tồn tại");
            return "register/form";
        }
        // Nếu chưa tồn tại thì lưu
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Users users1 = new Users();
        users1.setUsername(registerUser.getUsername());
        users1.setPassword(bcrypt.encode(registerUser.getPassword()));
        users1.setFirstName(registerUser.getFirstName());
        users1.setLastName(registerUser.getLastName());
        users1.setEmail(registerUser.getEmail());
        userService.save(users1);

        // Thông báo thành công
        session.setAttribute("myuser",users1);
        return "register/confirmation";
    }
}

package com.example.ProjectQuanLyHocSinh.controller;

import com.example.ProjectQuanLyHocSinh.DAO.TaiKhoan.RoleRepository;
import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Role;
import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Users;
import com.example.ProjectQuanLyHocSinh.service.TaiKhoan.UserService;
import com.example.ProjectQuanLyHocSinh.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;

    private RoleRepository roleRepository;

    @Autowired
    public RegisterController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model model){
        RegisterUser registerUser = new RegisterUser();
        model.addAttribute("registerUser",registerUser);
        return "register/form";
    }
//    @GetMapping("/hello")
//    public String hello(Model model){
////        RegisterUser registerUser = new RegisterUser();
////        model.addAttribute("registerUser",registerUser);
//        return "hello";
//    }

    @InitBinder
    public void initBinder(WebDataBinder data){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @PostMapping("/process")
    public String process(@Valid @ModelAttribute RegisterUser registerUser,
                          Model model, BindingResult result, HttpSession session) {
        String username = registerUser.getUsername();
        // check form validation
        if (result.hasErrors()) {
            return "register/form";
        }
         //kiem tra user da ton tai
        Users userExisting =userService.findByUserName(username);
        if(userExisting != null){
            model.addAttribute("registerUser",new RegisterUser());
            model.addAttribute("my_error","Tài khoản đã tồn tại");
            return "register/form";
        }

         //Nếu chưa tồn tại thì lưu
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Users users1 = new Users();
        users1.setUserName(registerUser.getUsername());
        users1.setPassWord(bcrypt.encode(registerUser.getPassword()));
        users1.setFirstName(registerUser.getFirstName());
        users1.setLastName(registerUser.getLastName());
        users1.setEmail(registerUser.getEmail());

        Role defaultRole = roleRepository.findByName("ROLE_USER");
        Collection<Role> roles = new ArrayList<>();
        roles.add(defaultRole);
        users1.setRoles(roles);

        userService.save(users1);

        // Thông báo thành công
        session.setAttribute("my_user",users1);
        return "register/confirmation";
    }
}

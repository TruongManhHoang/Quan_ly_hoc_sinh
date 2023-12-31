package com.example.ProjectQuanLyHocSinh.service.TaiKhoan;

import com.example.ProjectQuanLyHocSinh.DAO.TaiKhoan.RoleRepository;
import com.example.ProjectQuanLyHocSinh.DAO.TaiKhoan.UserRepository;
import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Role;
import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Users;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUserName(username);
        if(users == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new User(users.getUserName(), users.getPassWord(), rolesToAuthorities(users.getRoles()));
    }
    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public void save(Users users) {
        userRepository.save(users);
    }

    @Override
    public Users findByUserName(String userName) {
        Users users = userRepository.findByUserName(userName);
        return users;
    }
}

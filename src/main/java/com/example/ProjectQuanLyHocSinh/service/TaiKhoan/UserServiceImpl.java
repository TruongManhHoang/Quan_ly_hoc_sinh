package com.example.ProjectQuanLyHocSinh.service.TaiKhoan;

import com.example.ProjectQuanLyHocSinh.DAO.TaiKhoan.UserDAO;
import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Users;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(Users users) {
        userDAO.save(users);
    }

    @Override
    public Users update(Users users) {
        return userDAO.update(users);
    }

    @Override
    public Users findGiaoVienById(Integer id) {
        return userDAO.findGiaoVienById(id);
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }

    @Override
    public List<Users> findByUserName(String userName) {
       List<Users> users = userDAO.findByUserName(userName);
        return users;
    }
}

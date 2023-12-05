package com.example.ProjectQuanLyHocSinh.service.TaiKhoan;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Users;

import java.util.List;

public interface UserService {
    public void save(Users users);

    public Users update(Users users);

    public Users findGiaoVienById(Integer id);

    public void delete(Integer id);

    public List<Users> findByUserName(String userName);
}

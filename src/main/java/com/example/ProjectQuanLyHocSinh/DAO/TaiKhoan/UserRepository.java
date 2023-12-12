package com.example.ProjectQuanLyHocSinh.DAO.TaiKhoan;

import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    public Users findByUserName(String userName);
}

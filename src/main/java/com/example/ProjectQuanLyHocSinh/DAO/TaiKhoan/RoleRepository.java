package com.example.ProjectQuanLyHocSinh.DAO.TaiKhoan;

import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findByName(String name);
}

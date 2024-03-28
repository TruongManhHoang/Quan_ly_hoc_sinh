package com.example.ProjectQuanLyHocSinh.DAO.HocSinh;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocSinhRepository extends JpaRepository<HocSinh, Integer> {
//    public HocSinh findByName(String name);
}

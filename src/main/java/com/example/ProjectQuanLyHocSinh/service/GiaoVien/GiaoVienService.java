package com.example.ProjectQuanLyHocSinh.service.GiaoVien;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;

import java.util.List;

public interface GiaoVienService {
    public GiaoVien save(GiaoVien giaoVien);

    public GiaoVien update(GiaoVien giaoVien);

    public List<GiaoVien> findAll();

    public GiaoVien findById(Integer id);

    public void delete(Integer id);
}

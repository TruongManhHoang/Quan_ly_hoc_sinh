package com.example.ProjectQuanLyHocSinh.service.Teacher;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;

public interface TeacherService {
    public void save(GiaoVien giaoVien);

    public GiaoVien update(GiaoVien giaoVien);

    public GiaoVien findGiaoVienById(Integer id);

    public void delete(Integer id);
}

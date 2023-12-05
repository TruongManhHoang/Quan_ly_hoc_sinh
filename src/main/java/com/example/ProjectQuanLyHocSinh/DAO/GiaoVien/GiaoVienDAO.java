package com.example.ProjectQuanLyHocSinh.DAO.GiaoVien;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;

public interface GiaoVienDAO {
    public void save(GiaoVien giaoVien);

    public GiaoVien update(GiaoVien giaoVien);

    public GiaoVien findGiaoVienById(Integer id);

    public void delete(Integer id);
}

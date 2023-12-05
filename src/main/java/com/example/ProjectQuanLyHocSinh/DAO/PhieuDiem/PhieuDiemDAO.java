package com.example.ProjectQuanLyHocSinh.DAO.PhieuDiem;

import com.example.ProjectQuanLyHocSinh.Entity.PhieuDiem.PhieuDiem;
import com.example.ProjectQuanLyHocSinh.Entity.SoHocBa.SoHocBa;

public interface PhieuDiemDAO {
    public void save(PhieuDiem diem);

    public PhieuDiem update(PhieuDiem diem);

    public PhieuDiem findPhieuDiemById(Integer id);

    public void delete(Integer id);
}

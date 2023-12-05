package com.example.ProjectQuanLyHocSinh.DAO.SoHocBa;

import com.example.ProjectQuanLyHocSinh.Entity.SoDauBai.SoDauBai;
import com.example.ProjectQuanLyHocSinh.Entity.SoHocBa.SoHocBa;

public interface SoHocBaDAO {
    public void save(SoHocBa soHocBa);

    public SoHocBa update(SoHocBa soHocBa);

    public SoHocBa findSoHocBaById(Integer id);

    public void delete(Integer id);
}

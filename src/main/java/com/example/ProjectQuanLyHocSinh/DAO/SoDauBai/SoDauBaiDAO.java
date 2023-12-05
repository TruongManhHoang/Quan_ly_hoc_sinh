package com.example.ProjectQuanLyHocSinh.DAO.SoDauBai;

import com.example.ProjectQuanLyHocSinh.Entity.BangDiem.BangDiem;
import com.example.ProjectQuanLyHocSinh.Entity.SoDauBai.SoDauBai;

public interface SoDauBaiDAO {
    public void save(SoDauBai soDauBai);

    public SoDauBai update(SoDauBai soDauBai);

    public SoDauBai findBangDiemById(Integer id);

    public void delete(Integer id);
}

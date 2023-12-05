package com.example.ProjectQuanLyHocSinh.DAO.BangDiem;

import com.example.ProjectQuanLyHocSinh.Entity.BangDiem.BangDiem;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;

public interface BangDiemDAO {
    public void save(BangDiem bangDiem);

    public BangDiem update(BangDiem bangDiem);

    public BangDiem findBangDiemById(Integer id);

    public void delete(Integer id);
}

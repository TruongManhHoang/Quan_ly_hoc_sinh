package com.example.ProjectQuanLyHocSinh.DAO.TheHocSinh;

import com.example.ProjectQuanLyHocSinh.Entity.PhieuDiem.PhieuDiem;
import com.example.ProjectQuanLyHocSinh.Entity.TheHocSinh.TheHocSinh;

public interface TheHocSinhDAO {
    public void save(TheHocSinh hocSinh);

    public TheHocSinh update(TheHocSinh hocSinh);

    public TheHocSinh findTheHocSinhById(Integer id);

    public void delete(Integer id);
}

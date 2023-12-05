package com.example.ProjectQuanLyHocSinh.DAO.HocSinh;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;

public interface HocSinhDAO {

    public void save(HocSinh hocSinh);

    public HocSinh update(HocSinh hocSinh);

    public HocSinh findHocSinhById(Integer id);

    public void delete(Integer id);
}

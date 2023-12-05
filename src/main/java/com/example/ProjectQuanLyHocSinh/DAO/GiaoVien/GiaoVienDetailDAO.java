package com.example.ProjectQuanLyHocSinh.DAO.GiaoVien;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVienDetail;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinhDetail;

public interface GiaoVienDetailDAO {

    public void save(GiaoVienDetail giaoVienDetail);

    public HocSinhDetail update(HocSinhDetail hocSinhDetail);

    public HocSinhDetail findHocSinhDetailById(Integer id);

    public void delete(Integer id);
}

package com.example.ProjectQuanLyHocSinh.DAO.MonHoc;

import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;
import com.example.ProjectQuanLyHocSinh.Entity.MonHoc.MonHoc;

public interface MonHocDAO {
    public void save(MonHoc monHoc);

    public MonHoc update(MonHoc monHoc);

    public MonHoc findLopById(Integer id);

    public void delete(Integer id);
}

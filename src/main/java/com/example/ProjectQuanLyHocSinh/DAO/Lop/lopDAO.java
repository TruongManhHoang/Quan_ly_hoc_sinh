package com.example.ProjectQuanLyHocSinh.DAO.Lop;

import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;

public interface lopDAO {
    public void save(Lop lop);

    public Lop update(Lop lop);

    public Lop findLopById(Integer id);

    public void delete(Integer id);
}

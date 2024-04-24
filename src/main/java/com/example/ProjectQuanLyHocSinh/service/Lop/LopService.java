package com.example.ProjectQuanLyHocSinh.service.Lop;

import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;

import java.util.List;

public interface LopService {
    public Lop save(Lop lop);
    public List<Lop> findAll();
    public Lop update(Lop lop);
    public Lop findById(Integer id);
    public void delete(Integer id);
}

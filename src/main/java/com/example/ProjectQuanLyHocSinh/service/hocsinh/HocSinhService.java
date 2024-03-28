package com.example.ProjectQuanLyHocSinh.service.hocsinh;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;

import java.util.List;

public interface HocSinhService {
    public HocSinh save(HocSinh hocSinh);

    public HocSinh update(HocSinh hocSinh);

    public HocSinh findById(Integer id);
//    public HocSinh findByName(String name);

    public void delete(Integer id);

    public List<HocSinh> findAll();
}

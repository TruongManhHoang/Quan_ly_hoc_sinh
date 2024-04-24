package com.example.ProjectQuanLyHocSinh.service.hocsinh;

import com.example.ProjectQuanLyHocSinh.DAO.HocSinh.HocSinhRepository;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;


import java.util.List;
import java.util.Optional;

public interface hocSinhService {
    public HocSinh save(HocSinh hocSinh);
    public HocSinh update(HocSinh hocSinh);
    public List<HocSinh> findAll();
    public HocSinh findById(Integer id);
    public void delete(Integer id);

}

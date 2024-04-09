package com.example.ProjectQuanLyHocSinh.service.hocsinh;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinhDetail;

import java.util.List;

public interface HocSinhDetailService {
    public HocSinhDetail save(HocSinhDetail hocSinhDetail);
    public HocSinhDetail update(HocSinhDetail hocSinhDetail);
    public List<HocSinhDetail> findAll();
    public void delete(Integer id);
    public HocSinhDetail findById(Integer id);
}

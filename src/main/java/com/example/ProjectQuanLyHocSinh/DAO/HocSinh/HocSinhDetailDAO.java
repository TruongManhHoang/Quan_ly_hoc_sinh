package com.example.ProjectQuanLyHocSinh.DAO.HocSinh;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinhDetail;

public interface HocSinhDetailDAO {
    public void save(HocSinhDetail hocSinhDetail);

    public HocSinhDetail update(HocSinhDetail hocSinhDetail);

    public HocSinhDetail findHocSinhDetailById(Integer id);

    public void delete(Integer id);
}

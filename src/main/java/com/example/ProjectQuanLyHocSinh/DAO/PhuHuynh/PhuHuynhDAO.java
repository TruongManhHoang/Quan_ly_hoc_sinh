package com.example.ProjectQuanLyHocSinh.DAO.PhuHuynh;

import com.example.ProjectQuanLyHocSinh.Entity.PhuHuynh.PhuHuynh;
import com.example.ProjectQuanLyHocSinh.Entity.TheHocSinh.TheHocSinh;

public interface PhuHuynhDAO {
    public void save(PhuHuynh phuHuynh);

    public PhuHuynh update(PhuHuynh phuHuynh);

    public PhuHuynh findPhuHuynhById(Integer id);

    public void delete(Integer id);
}

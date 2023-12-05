package com.example.ProjectQuanLyHocSinh.DAO.Truong;

import com.example.ProjectQuanLyHocSinh.Entity.Truong.Truong;

public interface truongDAO {
    public void save(Truong truong);

    public Truong update(Truong truong);

    public Truong findTruongById(Integer id);

    public void delete(Integer id);

}

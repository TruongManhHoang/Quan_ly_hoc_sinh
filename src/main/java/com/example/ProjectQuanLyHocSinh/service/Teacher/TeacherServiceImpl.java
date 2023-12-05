package com.example.ProjectQuanLyHocSinh.service.Teacher;

import com.example.ProjectQuanLyHocSinh.DAO.GiaoVien.GiaoVienDAO;
import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{

    private GiaoVienDAO giaoVienDAO;

    @Autowired
    public TeacherServiceImpl(GiaoVienDAO giaoVienDAO) {
        this.giaoVienDAO = giaoVienDAO;
    }


    @Override
    public void save(GiaoVien giaoVien) {
        giaoVienDAO.save(giaoVien);
    }

    @Override
    public GiaoVien update(GiaoVien giaoVien) {
        GiaoVien giaoVien1 = giaoVienDAO.update(giaoVien);
        return giaoVien1;

    }

    @Override
    public GiaoVien findGiaoVienById(Integer id) {
        GiaoVien giaoVien = giaoVienDAO.findGiaoVienById(id);
        return giaoVien;
    }

    @Override
    public void delete(Integer id) {
        giaoVienDAO.delete(id);
    }

}

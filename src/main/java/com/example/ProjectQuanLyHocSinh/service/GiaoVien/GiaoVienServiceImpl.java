package com.example.ProjectQuanLyHocSinh.service.GiaoVien;

import com.example.ProjectQuanLyHocSinh.DAO.GiaoVien.GiaoVienRepository;
import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiaoVienServiceImpl implements GiaoVienService {

    private GiaoVienRepository giaoVienRepository;

    @Autowired
    public GiaoVienServiceImpl(GiaoVienRepository giaoVienRepository) {
        this.giaoVienRepository = giaoVienRepository;
    }

    @Override
    public GiaoVien save(GiaoVien giaoVien) {
        return  giaoVienRepository.saveAndFlush(giaoVien);
    }

    @Override
    public GiaoVien update(GiaoVien giaoVien) {
        return giaoVienRepository.saveAndFlush(giaoVien);

    }

    @Override
    public List<GiaoVien> findAll() {
        return giaoVienRepository.findAll();
    }



    @Override
    public GiaoVien findById(Integer id) {
        Optional<GiaoVien> optional = giaoVienRepository.findById(id);
        GiaoVien giaoVien = null;
        if (optional.isPresent()){
            giaoVien = optional.get();
        }else {
            throw new RuntimeException("Giao Vien not found for id " + id);
        }
        return giaoVien;
    }

    @Override
    public void delete(Integer id) {
        giaoVienRepository.deleteById(id);
    }


}

package com.example.ProjectQuanLyHocSinh.service.hocsinh;

import com.example.ProjectQuanLyHocSinh.DAO.HocSinh.HocSinhRepository;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class hocSinhServiceImpl implements hocSinhService{
    private HocSinhRepository hocSinhRepository;

    @Autowired
    public hocSinhServiceImpl(HocSinhRepository hocSinhRepository) {
        this.hocSinhRepository = hocSinhRepository;
    }

    @Transactional
    @Override
    public HocSinh save(HocSinh hocSinh) {
        return hocSinhRepository.saveAndFlush(hocSinh);
    }
    @Transactional
    @Override
    public HocSinh update(HocSinh hocSinh) {
        return hocSinhRepository.saveAndFlush(hocSinh);
    }

    @Override
    public List<HocSinh> findAll() {
        return hocSinhRepository.findAll();
    }

    @Override
    public HocSinh findById(Integer id) {
        Optional<HocSinh> optional = hocSinhRepository.findById(id);
        HocSinh hocSinh = null;
        if(optional.isPresent()){
            hocSinh = optional.get();
        }else {
            throw new RuntimeException("Hoc sinh not found for id " + id);
        }
        return hocSinh;
    }

    @Override
    public void delete(Integer id) {
        hocSinhRepository.deleteById(id);
    }
}

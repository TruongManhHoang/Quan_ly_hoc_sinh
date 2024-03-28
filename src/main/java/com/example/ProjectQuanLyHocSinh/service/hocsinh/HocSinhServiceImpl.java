package com.example.ProjectQuanLyHocSinh.service.hocsinh;

import com.example.ProjectQuanLyHocSinh.DAO.HocSinh.HocSinhRepository;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocSinhServiceImpl implements HocSinhService {
    private HocSinhRepository hocSinhRepository;

    @Autowired
    public HocSinhServiceImpl(HocSinhRepository hocSinhRepository) {
        this.hocSinhRepository = hocSinhRepository;
    }


    @Transactional
    @Override
    public HocSinh save(HocSinh hocSinh) {
        return hocSinhRepository.saveAndFlush(hocSinh);
    }

    @Override
    public HocSinh update(HocSinh hocSinh) {
        return hocSinhRepository.saveAndFlush(hocSinh);
    }

//    @Transactional
//    @Override
//    public HocSinh update(HocSinh hocSinh Integer id) {
//        HocSinh hocSinh1 = hocSinhRepository.findById(hocSinh.getId());
//        hocSinh1.setTen(hocSinh.getTen());
//        hocSinh1.setHoVaDem(hocSinh.getHoVaDem());
//        hocSinh1.setEmail(hocSinh.getEmail());
//        return hocSinhRepository.save(hocSinh1);
//    }

    @Override
    public HocSinh findById(Integer id) {
        Optional<HocSinh> optional = hocSinhRepository.findById(id);
        HocSinh hocSinh = null;
        if(optional.isPresent()){
            hocSinh = optional.get();
        }else {
            throw  new RuntimeException("Hoc sinh not found for id " + id);
        }
        return hocSinh;
    }
//    @Override
//    public HocSinh findByName(String name) {
//        return hocSinhRepository.findByName(name);
//    }

    @Transactional
    @Override
    public void delete(Integer id) {
        hocSinhRepository.deleteById(id);
    }

    @Override
    public List<HocSinh> findAll() {
        return hocSinhRepository.findAll();
    }
}

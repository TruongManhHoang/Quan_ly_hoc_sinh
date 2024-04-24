package com.example.ProjectQuanLyHocSinh.service.Lop;

import com.example.ProjectQuanLyHocSinh.DAO.Lop.LopRepository;
import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LopServiceImpl implements LopService{

    private LopRepository lopRepository;

    @Autowired
    public LopServiceImpl(LopRepository lopRepository) {
        this.lopRepository = lopRepository;
    }

    @Override
    public Lop save(Lop lop) {
        return lopRepository.saveAndFlush(lop);
    }

    @Override
    public List<Lop> findAll() {
        return lopRepository.findAll();
    }

    @Override
    public Lop update(Lop lop) {
        return lopRepository.saveAndFlush(lop);
    }

    @Override
    public Lop findById(Integer id) {
        Optional<Lop> optional = lopRepository.findById(id);
        Lop lop = null;
        if (optional.isPresent()){
            lop = optional.get();
        }else {
            throw new RuntimeException("Lop not found for id " + id);
        }
        return lop;
    }

    @Override
    public void delete(Integer id) {
        lopRepository.deleteById(id);
    }
}

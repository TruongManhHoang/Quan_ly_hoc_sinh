package com.example.ProjectQuanLyHocSinh.service.hocsinh;

import com.example.ProjectQuanLyHocSinh.DAO.HocSinh.HocSinhDetailRepository;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinhDetail;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class HocSinhDetailImpl implements HocSinhDetailService {
    private HocSinhDetailRepository hocSinhDetailRepository;

    @Autowired
    public HocSinhDetailImpl(HocSinhDetailRepository hocSinhDetailRepository) {
        this.hocSinhDetailRepository = hocSinhDetailRepository;
    }

    @Override
    @Transactional
    public HocSinhDetail save(HocSinhDetail hocSinhDetail) {
        return hocSinhDetailRepository.saveAndFlush(hocSinhDetail);
    }

    @Override
    @Transactional
    public HocSinhDetail update(HocSinhDetail hocSinhDetail) {
        return hocSinhDetailRepository.saveAndFlush(hocSinhDetail);
    }

    @Override
    public List<HocSinhDetail> findAll() {
        return hocSinhDetailRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        hocSinhDetailRepository.deleteById(id);
    }

    @Override
    public HocSinhDetail findById(Integer id) {
        Optional<HocSinhDetail> optional = hocSinhDetailRepository.findById(id);
        HocSinhDetail hocSinhDetail = null;
        if (optional.isPresent()) {
            hocSinhDetail = optional.get();
        } else {
            throw new RuntimeException("Hoc sinh not found for id " + id);
        }
        return hocSinhDetail;
    }
}

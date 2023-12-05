package com.example.ProjectQuanLyHocSinh.DAO.HocSinh;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class HocSinhDAOImpl implements HocSinhDAO{

    private EntityManager entityManager;

    @Autowired
    public HocSinhDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(HocSinh hocSinh) {
        entityManager.persist(hocSinh);
    }

    @Override
    @Transactional
    public HocSinh update(HocSinh hocSinh) {
        return entityManager.merge(hocSinh);
    }

    @Override
    public HocSinh findHocSinhById(Integer id) {
        return entityManager.find(HocSinh.class,id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        HocSinh hocSinh = entityManager.find(HocSinh.class,id);
        entityManager.remove(hocSinh);
        entityManager.flush();
    }
}

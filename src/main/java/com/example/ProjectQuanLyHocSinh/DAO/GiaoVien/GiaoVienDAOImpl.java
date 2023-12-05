package com.example.ProjectQuanLyHocSinh.DAO.GiaoVien;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GiaoVienDAOImpl implements GiaoVienDAO {

    private EntityManager entityManager;

    @Autowired
    public GiaoVienDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(GiaoVien giaoVien) {
        entityManager.persist(giaoVien);
    }

    @Override
    @Transactional
    public GiaoVien update(GiaoVien giaoVien) {
            return entityManager.merge(giaoVien);
    }

    @Override
    public GiaoVien findGiaoVienById(Integer id) {
        return entityManager.find(GiaoVien.class,id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        GiaoVien giaoVien = entityManager.find(GiaoVien.class,id);
        entityManager.remove(giaoVien);
        entityManager.flush();
    }
}

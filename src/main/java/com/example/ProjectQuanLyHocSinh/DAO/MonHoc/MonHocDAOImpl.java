package com.example.ProjectQuanLyHocSinh.DAO.MonHoc;

import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;
import com.example.ProjectQuanLyHocSinh.Entity.MonHoc.MonHoc;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class MonHocDAOImpl implements MonHocDAO {

    private EntityManager entityManager;

    public MonHocDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(MonHoc monHoc) {
        entityManager.persist(monHoc);
    }

    @Override
    @Transactional
    public MonHoc update(MonHoc monHoc) {
        return entityManager.merge(monHoc);
    }

    @Override
    public MonHoc findLopById(Integer id) {
        return entityManager.find(MonHoc.class,id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        MonHoc monHoc = entityManager.find(MonHoc.class,id);
        entityManager.remove(monHoc);
        entityManager.flush();
    }
}

package com.example.ProjectQuanLyHocSinh.DAO.SoDauBai;

import com.example.ProjectQuanLyHocSinh.Entity.BangDiem.BangDiem;
import com.example.ProjectQuanLyHocSinh.Entity.SoDauBai.SoDauBai;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SoDauBaiDAOImpl implements SoDauBaiDAO{

    private EntityManager entityManager;

    @Autowired
    public SoDauBaiDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(SoDauBai soDauBai) {
        entityManager.persist(soDauBai);
    }

    @Override
    public SoDauBai update(SoDauBai soDauBai) {
        return entityManager.merge(soDauBai);
    }

    @Override
    public SoDauBai findBangDiemById(Integer id) {
        return entityManager.find(SoDauBai.class,id);
    }

    @Override
    public void delete(Integer id) {
        SoDauBai soDauBai = entityManager.find(SoDauBai.class,id);
        entityManager.remove(soDauBai);
        entityManager.flush();
    }
}

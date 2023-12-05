package com.example.ProjectQuanLyHocSinh.DAO.Truong;

import com.example.ProjectQuanLyHocSinh.Entity.Truong.Truong;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class truongDAOImpl implements truongDAO{

    private EntityManager entityManager;

    @Autowired
    public truongDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Truong truong) {
        entityManager.persist(truong);
    }

    @Override
    @Transactional
    public Truong update(Truong truong) {
        return entityManager.merge(truong);
    }

    @Override
    public Truong findTruongById(Integer id) {
        return entityManager.find(Truong.class,id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Truong truong = entityManager.find(Truong.class,id);
        entityManager.remove(truong);
        entityManager.flush();
    }
}

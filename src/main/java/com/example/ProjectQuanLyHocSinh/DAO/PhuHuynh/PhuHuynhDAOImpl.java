package com.example.ProjectQuanLyHocSinh.DAO.PhuHuynh;

import com.example.ProjectQuanLyHocSinh.Entity.PhuHuynh.PhuHuynh;
import com.example.ProjectQuanLyHocSinh.Entity.TheHocSinh.TheHocSinh;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhuHuynhDAOImpl implements PhuHuynhDAO{

    private EntityManager entityManager;

    @Autowired
    public PhuHuynhDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(PhuHuynh phuHuynh) {
        entityManager.persist(phuHuynh);
    }

    @Override
    public PhuHuynh update(PhuHuynh phuHuynh) {
        return entityManager.merge(phuHuynh);
    }

    @Override
    public PhuHuynh findPhuHuynhById(Integer id) {
        return entityManager.find(PhuHuynh.class,id);
    }

    @Override
    public void delete(Integer id) {
        PhuHuynh phuHuynh = entityManager.find(PhuHuynh.class,id);
        entityManager.remove(phuHuynh);
        entityManager.flush();
    }
}

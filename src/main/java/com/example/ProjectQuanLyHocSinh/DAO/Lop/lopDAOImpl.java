package com.example.ProjectQuanLyHocSinh.DAO.Lop;

import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class lopDAOImpl implements lopDAO{
    private EntityManager entityManager;

    @Autowired
    public lopDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Lop lop) {
        entityManager.persist(lop);
    }

    @Override
    @Transactional
    public Lop update(Lop lop) {
        return entityManager.merge(lop);
    }

    @Override
    public Lop findLopById(Integer id) {
        return entityManager.find(Lop.class,id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Lop lop = entityManager.find(Lop.class,id);
        entityManager.remove(lop);
        entityManager.flush();
    }


}

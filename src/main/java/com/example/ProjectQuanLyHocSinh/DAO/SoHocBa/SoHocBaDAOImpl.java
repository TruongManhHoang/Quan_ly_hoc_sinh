package com.example.ProjectQuanLyHocSinh.DAO.SoHocBa;

import com.example.ProjectQuanLyHocSinh.Entity.SoDauBai.SoDauBai;
import com.example.ProjectQuanLyHocSinh.Entity.SoHocBa.SoHocBa;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SoHocBaDAOImpl implements SoHocBaDAO {

    private EntityManager entityManager;

    @Autowired
    public SoHocBaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(SoHocBa soHocBa) {
        entityManager.persist(soHocBa);
    }

    @Override
    public SoHocBa update(SoHocBa soHocBa) {
        return entityManager.merge(soHocBa);
    }

    @Override
    public SoHocBa findSoHocBaById(Integer id) {
        return entityManager.find(SoHocBa.class,id);
    }

    @Override
    public void delete(Integer id) {
        SoHocBa soHocBa = entityManager.find(SoHocBa.class,id);
        entityManager.remove(soHocBa);
        entityManager.flush();
    }
}

package com.example.ProjectQuanLyHocSinh.DAO.PhieuDiem;

import com.example.ProjectQuanLyHocSinh.Entity.PhieuDiem.PhieuDiem;
import com.example.ProjectQuanLyHocSinh.Entity.SoHocBa.SoHocBa;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhieuDiemDAOImpl implements PhieuDiemDAO{

    private EntityManager entityManager;

    @Autowired
    public PhieuDiemDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(PhieuDiem diem) {
        entityManager.persist(diem);
    }

    @Override
    public PhieuDiem update(PhieuDiem diem) {
        return entityManager.merge(diem);
    }

    @Override
    public PhieuDiem findPhieuDiemById(Integer id) {
        return entityManager.find(PhieuDiem.class,id);
    }

    @Override
    public void delete(Integer id) {
        PhieuDiem phieuDiem = entityManager.find(PhieuDiem.class,id);
        entityManager.remove(phieuDiem);
        entityManager.flush();
    }
}

package com.example.ProjectQuanLyHocSinh.DAO.TheHocSinh;

import com.example.ProjectQuanLyHocSinh.Entity.PhieuDiem.PhieuDiem;
import com.example.ProjectQuanLyHocSinh.Entity.TheHocSinh.TheHocSinh;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TheHocSinhDAOImpl implements TheHocSinhDAO{

    private EntityManager entityManager;

    @Autowired
    public TheHocSinhDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(TheHocSinh hocSinh) {
        entityManager.persist(hocSinh);
    }

    @Override
    public TheHocSinh update(TheHocSinh hocSinh) {
        return entityManager.merge(hocSinh);
    }

    @Override
    public TheHocSinh findTheHocSinhById(Integer id) {
        return entityManager.find(TheHocSinh.class,id);
    }

    @Override
    public void delete(Integer id) {
        TheHocSinh theHocSinh = entityManager.find(TheHocSinh.class,id);
        entityManager.remove(theHocSinh);
        entityManager.flush();
    }
}

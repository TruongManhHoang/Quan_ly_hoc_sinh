package com.example.ProjectQuanLyHocSinh.DAO.HocSinh;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinhDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class HocSinhDetailDAOImpl implements HocSinhDetailDAO {

    private EntityManager entityManager;

    @Autowired
    public HocSinhDetailDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(HocSinhDetail hocSinhDetail) {
        entityManager.persist(hocSinhDetail);
    }

    @Override
    @Transactional
    public HocSinhDetail update(HocSinhDetail hocSinhDetail) {
        return entityManager.merge(hocSinhDetail);
    }

    @Override
    public HocSinhDetail findHocSinhDetailById(Integer id) {
        return entityManager.find(HocSinhDetail.class,id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        HocSinhDetail hocSinhDetail = entityManager.find(HocSinhDetail.class,id);
        entityManager.remove(hocSinhDetail);
        entityManager.flush();
    }
}

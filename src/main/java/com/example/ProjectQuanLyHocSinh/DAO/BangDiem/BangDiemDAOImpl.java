package com.example.ProjectQuanLyHocSinh.DAO.BangDiem;

import com.example.ProjectQuanLyHocSinh.Entity.BangDiem.BangDiem;
import com.example.ProjectQuanLyHocSinh.Entity.MonHoc.MonHoc;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BangDiemDAOImpl implements BangDiemDAO {

    private EntityManager entityManager;

    @Autowired
    public BangDiemDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(BangDiem bangDiem) {
        entityManager.persist(bangDiem);
    }

    @Override
    @Transactional
    public BangDiem update(BangDiem bangDiem) {
        return entityManager.merge(bangDiem);
    }

    @Override
    public BangDiem findBangDiemById(Integer id) {
        return entityManager.find(BangDiem.class,id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        BangDiem bangDiem = entityManager.find(BangDiem.class,id);
        entityManager.remove(bangDiem);
        entityManager.flush();
    }
}

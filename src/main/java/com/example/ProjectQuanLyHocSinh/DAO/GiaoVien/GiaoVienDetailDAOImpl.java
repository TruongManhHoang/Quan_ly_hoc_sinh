package com.example.ProjectQuanLyHocSinh.DAO.GiaoVien;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVienDetail;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinhDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class GiaoVienDetailDAOImpl implements GiaoVienDetailDAO{

    private EntityManager entityManager;

    @Autowired
    public GiaoVienDetailDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(GiaoVienDetail giaoVienDetail) {
        entityManager.persist(giaoVienDetail);
    }

    @Override
    public HocSinhDetail update(HocSinhDetail hocSinhDetail) {
        return entityManager.merge(hocSinhDetail);
    }

    @Override
    public HocSinhDetail findHocSinhDetailById(Integer id) {
        return entityManager.find(HocSinhDetail.class,id);
    }

    @Override
    public void delete(Integer id) {
        HocSinhDetail hocSinhDetail = entityManager.find(HocSinhDetail.class,id);
        entityManager.remove(hocSinhDetail);
        entityManager.flush();
    }
}

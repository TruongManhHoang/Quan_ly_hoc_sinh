package com.example.ProjectQuanLyHocSinh.DAO.TaiKhoan;

import com.example.ProjectQuanLyHocSinh.Entity.TaiKhoan.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Users users) {
        entityManager.persist(users);
    }

    @Override
    public Users update(Users users) {
        return entityManager.merge(users);
    }

    @Override
    public Users findGiaoVienById(Integer id) {
        return entityManager.find(Users.class,id);
    }

    @Override
    public void delete(Integer id) {
        Users users = entityManager.find(Users.class,id);
        entityManager.remove(users);
    }

    @Override
    public List<Users> findByUserName(String userName) {
        String jpql = "SELECT users u WHERE u.username =: userName";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        query.setParameter("userName", userName);
        return query.getResultList();
    }

}

package com.project.parking.repository.impl;

import com.project.parking.entity.Admin;
import com.project.parking.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
@RequiredArgsConstructor
public class AdminRepositoryImpl implements AdminRepository {
    private final EntityManager entityManager;
    @Override
    public Admin saveAndFlush(Admin admin) {
        entityManager.createNativeQuery("INSERT INTO m_admin (id, name) VALUES (?,?)")
                .setParameter(1, UUID.randomUUID())
                .setParameter(2, admin.getName())
                .executeUpdate();
        entityManager.flush();

        return findByName(admin.getName());
    }

    @Override
    public Admin findById(String id) {
        return (Admin) entityManager.createNativeQuery("SELECT * FROM m_admin WHERE id = ?", Admin.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public Admin findByName(String name) {
        return (Admin) entityManager.createNativeQuery("SELECT * FROM m_admin WHERE name = ?", Admin.class)
                .setParameter(1, name)
                .getSingleResult();
    }

    @Override
    public List findAll() {
        return entityManager.createNativeQuery("SELECT * FROM m_admin", Admin.class)
                .getResultList();
    }

    @Override
    public Admin update(Admin admin) {
        entityManager.createNativeQuery("UPDATE m_admin SET name = ? WHERE id = ?")
                .setParameter(2, admin.getId())
                .setParameter(1, admin.getName())
                .executeUpdate();
        return findById(admin.getId());
    }
}

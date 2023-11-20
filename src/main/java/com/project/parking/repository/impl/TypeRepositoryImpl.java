package com.project.parking.repository.impl;

import com.project.parking.entity.Type;
import com.project.parking.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
@RequiredArgsConstructor
public class TypeRepositoryImpl implements TypeRepository {
    private final EntityManager entityManager;
    @Override
    public Type saveAndFlush(Type type) {
        entityManager.createNativeQuery("INSERT INTO m_type (id, name_type, price) values(?,?,?)")
                .setParameter(1, UUID.randomUUID())
                .setParameter(2, type.getNameType().name())
                .setParameter(3, type.getPrice())
                .executeUpdate();
        entityManager.flush();

        return findByName(type.getNameType().name());
    }

    @Override
    public Type findByName(String name) {
        return (Type) entityManager.createNativeQuery("SELECT * FROM m_type WHERE name_type = ?", Type.class)
                .setParameter(1, name)
                .getSingleResult();
    }

    @Override
    public List findAll() {
        return entityManager.createNativeQuery("SELECT * FROM m_type", Type.class)
                .getResultList();
    }

    @Override
    public Type update(Type type) {
        entityManager.createNativeQuery("UPDATE m_type SET name_type = ?, price = ? WHERE id = ?")
                .setParameter(3, type.getId())
                .setParameter(1, type.getNameType().name())
                .setParameter(2, type.getPrice())
                .executeUpdate();
        return findByName(type.getNameType().name());
    }

}

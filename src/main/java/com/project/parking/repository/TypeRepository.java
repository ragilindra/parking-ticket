package com.project.parking.repository;

import com.project.parking.entity.Type;

import java.util.List;

public interface TypeRepository {
    Type saveAndFlush(Type type);
    Type findByName(String name);
    List<Type> findAll();
    Type update(Type type);
}

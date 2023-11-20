package com.project.parking.repository;

import com.project.parking.entity.Admin;
import com.project.parking.entity.Type;

import java.util.List;

public interface AdminRepository {
    Admin saveAndFlush(Admin admin);
    Admin findById(String id);
    Admin findByName(String name);
    List<Admin> findAll();
    Admin update(Admin admin);
}

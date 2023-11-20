package com.project.parking.service;

import com.project.parking.dto.request.NewAdminRequest;
import com.project.parking.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin create(NewAdminRequest request);
    Admin findById(String id);
    List<Admin> findAll();
    Admin update(Admin admin);


}

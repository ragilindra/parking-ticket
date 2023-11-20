package com.project.parking.service.impl;

import com.project.parking.dto.request.NewAdminRequest;
import com.project.parking.entity.Admin;
import com.project.parking.repository.AdminRepository;
import com.project.parking.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    @Override
    public Admin create(NewAdminRequest request) {
        Admin admin = Admin.builder()
                .name(request.getName())
                .build();
        return adminRepository.saveAndFlush(admin);
    }

    @Override
    public Admin findById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin update(Admin admin) {
        return adminRepository.update(admin);
    }
}

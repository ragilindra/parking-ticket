package com.project.parking.controller;

import com.project.parking.entity.Admin;
import com.project.parking.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminRepository adminRepository;

    @PostMapping
    public Admin createNew(Admin admin){
        return adminRepository.saveAndFlush(admin);
    }

    @GetMapping("/{id}")
    public Admin getById(@PathVariable String id){
        return adminRepository.findById(id);
    }

    @GetMapping
    public List<Admin> getAll(){
        return adminRepository.findAll();
    }

    @PutMapping
    public Admin update(Admin admin) {
        return adminRepository.update(admin);
    }
}

package com.project.parking.controller;

import com.project.parking.dto.request.NewAdminRequest;
import com.project.parking.entity.Admin;
import com.project.parking.repository.AdminRepository;
import com.project.parking.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public Admin createNew(@RequestBody NewAdminRequest request){
        return adminService.create(request);
    }

    @GetMapping("/{id}")
    public Admin getById(@PathVariable String id){
        return adminService.findById(id);
    }

    @GetMapping
    public List<Admin> getAll(){
        return adminService.findAll();
    }

    @PutMapping
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }
}

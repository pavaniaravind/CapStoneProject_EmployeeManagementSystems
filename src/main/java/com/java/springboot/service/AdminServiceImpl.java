package com.java.springboot.service;

import com.java.springboot.model.Admin;
import com.java.springboot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public void saveAdmin(Admin a) {
        this.adminRepository.save(a);
    }
}

package com.java.springboot.service;

import com.java.springboot.model.Admin;

import java.util.List;

public interface AdminService {
    Admin findByEmail(String email);
    void saveAdmin(Admin a);
    List<Admin> getAllAdmins();

}

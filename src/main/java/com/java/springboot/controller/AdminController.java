package com.java.springboot.controller;

import com.java.springboot.model.Admin;
import com.java.springboot.model.Employee;
import com.java.springboot.repository.EmployeeRepository;
import com.java.springboot.service.AdminService;
import com.java.springboot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
@Slf4j
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;

    // getting employee list corresponding to the admin
    @GetMapping("/list_employees")
    public String viewEmployee(Model model, Principal principal){
        String name = principal.getName();
        Admin admin = adminService.findByEmail(name);
     //  model.addAttribute("listEmployees",employeeService.getAllEmployees());
        model.addAttribute("name", admin.getName());
        model.addAttribute("listEmployees",employeeService.getAllEmployeesById(admin.getId()));

        return "employeeView";
    }
    // Register as an Admin
    @GetMapping("/adminRegister")
    public String register(Model model){
        Admin admin = new Admin();
        model.addAttribute("admin",admin);
        return "register_admin";
    }
    // After registering save the admin info into database
    @PostMapping("/saveAdmin")
    public String saveAdmin(@ModelAttribute("admin") Admin admin){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
        adminService.saveAdmin(admin);
        log.info("Admin saved to database");
        return "adminView";
    }
    // custom login page
    @GetMapping("/login")
    public String login(){
        return "login";
    }



}


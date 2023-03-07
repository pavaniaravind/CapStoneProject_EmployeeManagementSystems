package com.java.springboot.adminTests;

import com.java.springboot.SpringbootPmsApplication;
import com.java.springboot.model.Admin;
import com.java.springboot.model.Employee;
import com.java.springboot.repository.EmployeeRepository;
import com.java.springboot.service.AdminService;
import com.java.springboot.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest(classes = SpringbootPmsApplication.class)
public class ServiceTest {
    @Autowired
   AdminService adminService;
    @Autowired
    EmployeeRepository repository;
    @Autowired
    EmployeeService employeeService;

    @Test
    public void testGetAllAdmins(){
        List<Admin> adminList = adminService.getAllAdmins();
        assertThat(adminList.size()).isGreaterThan(0);
    }

}

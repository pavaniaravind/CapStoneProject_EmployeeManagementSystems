package com.java.springboot.adminTests;

import com.java.springboot.SpringbootPmsApplication;
import com.java.springboot.model.Admin;
import com.java.springboot.model.Employee;
import com.java.springboot.repository.AdminRepository;
import com.java.springboot.repository.EmployeeRepository;
import com.java.springboot.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;
import org.springframework.test.annotation.Rollback;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
/*@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)*/
@SpringBootTest(classes = SpringbootPmsApplication.class)
public class RepoTest {
    @Autowired
    AdminRepository repository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testFindAdminByEmail(){
        String email = "admin1@test.com";
        Admin admin = repository.findByEmail(email);
        assertThat(admin).isNotNull();
    }

}

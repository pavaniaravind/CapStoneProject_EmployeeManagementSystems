package com.java.springboot.controller;


import com.java.springboot.model.Admin;
import com.java.springboot.model.Company;
import com.java.springboot.model.Employee;
import com.java.springboot.repository.EmployeeRepository;
import com.java.springboot.service.AdminService;
import com.java.springboot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AdminService adminService;
    @Autowired
    EmployeeRepository employeeRepository;

    //Entering employee information for specific admin after admin logged in
    @GetMapping("/register")
    public String register(Model model){
        // create a model to bind data from the form
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "register";
    }
    // To update employee information
    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id")int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        log.info("Employee updated.");
        return "update_employee";
    }
    // save employee information in the database.
    @PostMapping("/saveEmployee")
    public String processingEmployee(@ModelAttribute("employee") Employee employee,Principal principal) {
        try {
            String name = principal.getName();
            Admin admin = adminService.findByEmail(name);
            employee.setAdmin(admin);
            admin.getEmployees().add(employee);
            adminService.saveAdmin(admin);

        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Employee saved");
        return "redirect:/list_employees";

    }
    // save the updated employee information
    @PostMapping("/updateEmployee")
    public String update(@ModelAttribute("employee") Employee employee, Principal principal){
        String name = principal.getName();
        Admin admin = adminService.findByEmail(name);
        employee.setAdmin(admin);
        employeeService.saveEmployee(employee);
        return "redirect:/list_employees";
    }

    // delete employee
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id")int id,Principal principal) {
        String name = principal.getName();
        Admin admin = adminService.findByEmail(name);
        Employee employee = employeeRepository.findById(id).get();
        if(admin.getId() == employee.getAdmin().getId()){
            admin.getEmployees().remove(employee);
            adminService.saveAdmin(admin);
        }
        return "redirect:/list_employees";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable(value="id")int id,@ModelAttribute("company") Company company, Principal principal, Model model){
        String name = principal.getName();
        Admin admin = adminService.findByEmail(name);
        Employee employee = employeeRepository.findById(id).get();
        model.addAttribute("empName", employee.getFirstName());
        model.addAttribute("employee",employee);
        company.setName("Euphoric");
        model.addAttribute("company",company.getName());
        return "empdetails";
    }


}


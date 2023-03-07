package com.java.springboot.service;

import com.java.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    // To get all the list of employees
    List<Employee> getAllEmployees();
    // To save the employee
    void saveEmployee(Employee e);
    Employee findById(int id);

    void deleteById(int id);

    List<Employee> getAllEmployeesById(int id);

}

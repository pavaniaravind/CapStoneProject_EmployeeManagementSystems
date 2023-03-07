package com.java.springboot.service;

import com.java.springboot.model.Employee;
import com.java.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public void saveEmployee(Employee e) {
        this.employeeRepository.save(e);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optional = this.employeeRepository.findById(id);
        Employee e = null;
        if(optional.isPresent()){
            e = optional.get();
        }else {
            throw new RuntimeException("Employee not found");
        }
        return e;
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeesById(int id) {
        List<Employee> e = this.employeeRepository.findEmployeeByAdminID(id);
        return e;
    }
}

package com.java.springboot.repository;

import com.java.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    List<Employee> findAll();

    @Override
    <S extends Employee> S save(S entity);

    @Override
    Optional<Employee> findById(Integer integer);

    @Query("from Employee e where e.admin.id=:id")
    List<Employee> findEmployeeByAdminID(@Param("id")int adminId);

}

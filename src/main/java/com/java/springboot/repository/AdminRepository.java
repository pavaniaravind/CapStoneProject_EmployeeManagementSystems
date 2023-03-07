package com.java.springboot.repository;

import com.java.springboot.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query("SELECT a from Admin a where a.email=?1")
    Admin findByEmail(String email);

    @Override
    Optional<Admin> findById(Integer integer);

}

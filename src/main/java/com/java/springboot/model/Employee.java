package com.java.springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

   // @GeneratedValue(strategy = GenerationType.UUID)
  //  private UUID id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String dob;
    private String salary;
    private String doj;
    private String employeeRole;
    @ManyToOne
    private Admin admin;

    @ManyToOne
    private Company company;



}

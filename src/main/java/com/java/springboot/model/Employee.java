package com.java.springboot.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee {

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

}

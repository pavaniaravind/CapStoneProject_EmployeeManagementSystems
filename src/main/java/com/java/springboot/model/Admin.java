package com.java.springboot.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private String adminRole;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Employee> employees;

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

}

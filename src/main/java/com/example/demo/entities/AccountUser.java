package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AccountUser extends Dates{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String first_name;
    @Column(nullable = false, length = 50)
    private String last_name;
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 20)
    private String phone_number;
    private boolean activated = false;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Profile profile;
    @OneToMany(mappedBy = "account_user")
    private List<Vehicle> vehicles; 
}

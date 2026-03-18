package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data 
public class Profile extends Dates{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 30)
    private String code_profile;
    @Column(nullable = true, length = 100)
    private String label;
    @OneToMany(mappedBy = "profile")
    private List<AccountUser> accounts;
    @OneToMany(mappedBy = "profile")
    private List<Permission> permissions;
}

package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company extends Dates{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 30)
    private String codeCompany;
    @Column(nullable = true, length = 100)
    private String label;
    @Column(nullable = false, length = 200)
    private String address;
    @Column(nullable = false, length = 20)
    private String phoneNumber;
    @OneToMany(mappedBy = "company")
    private List<Vehicle> vehicles;
    @OneToMany(mappedBy = "company")
    private List<AccountUser> accounts; 
    @OneToMany(mappedBy = "company")
    private List<Collaborater> collaboraters;
} 

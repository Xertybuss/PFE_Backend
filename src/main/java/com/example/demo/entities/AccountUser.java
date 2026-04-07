package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountUser extends Dates{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 20)
    private String phoneNumber;
    private boolean activated = false;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;
    @OneToMany(mappedBy = "accountUser")
    private List<Vehicle> vehicles; 
}

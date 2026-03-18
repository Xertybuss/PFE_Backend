package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Permission extends Dates{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true, length = 30)
    private String code_permission;
    @Column(nullable = true, length = 100)
    private String label;
    @ManyToOne
    private Profile profile;
}

package com.example.demo.entities;

import java.util.List;

import com.example.demo.enums.TypeVehicle;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehicle extends Dates{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true, length = 20)
    private String imei;
    @Column(nullable = false, unique = true, length = 15)
    private String immatriculation;
    @Column(nullable = true, length = 100)
    private String label;
    @Enumerated(value = EnumType.STRING)
    private TypeVehicle vehicle_type;
    @Column(nullable = false)
    private int capacity_places;
    @Column(nullable = false, scale = 2)
    private double capacity_weight;
    @ManyToOne
    private Company company;
    @ManyToOne
    private AccountUser account_user;
    @OneToMany(mappedBy = "vehicle")
    private List<Usage> usages;
}

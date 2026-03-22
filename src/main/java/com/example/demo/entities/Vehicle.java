package com.example.demo.entities;

import java.util.List;

import com.example.demo.enums.TypeVehicle;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private TypeVehicle vehicleType;
    @Column(nullable = false)
    private int capacityPlaces;
    @Column(nullable = false, scale = 2)
    private double capacityWeight;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    private AccountUser accountUser;
    @OneToMany(mappedBy = "vehicle")
    private List<Usage> usages;
}

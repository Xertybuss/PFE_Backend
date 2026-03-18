package com.example.demo.entities;

import java.util.List;

import com.example.demo.enums.TypeCollab;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Collaborater extends Dates{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String first_name;
    @Column(nullable = false, length = 50)
    private String last_name;
    @Column(nullable = false, length = 20)
    private String phone_number;
    @Column(nullable = false, length = 150)
    private String home_location;
    @Column(nullable = false, length = 200)
    private String address;
    @Enumerated(value = EnumType.STRING)
    private TypeCollab collab_type;
    @ManyToOne
    private Company company;
    @OneToMany(mappedBy = "collaborater")
    private List<Usage> usages;
}

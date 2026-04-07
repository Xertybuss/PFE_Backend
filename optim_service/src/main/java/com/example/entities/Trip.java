package com.example.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;
    @Column(nullable = false)
    private Date date_start;
    @Column(nullable = false)
    private Date date_end;
    private Boolean status_generated;
    @Column(nullable = false)
    private double total_distance;
    @Column(nullable = false)
    private int total_duration;
    @Column(nullable = false)
    private int total_passengers;
    @OneToMany(mappedBy = "trip")
    private List<ConstParameter> parameters;
}

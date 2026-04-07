package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConstParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String code_param;
    @Column(nullable = false)
    private String value_param;
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;
}

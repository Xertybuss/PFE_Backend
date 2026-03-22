package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends Dates{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 30)
    private String codePermission;
    @Column(nullable = true, length = 100)
    private String label;
    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;
}

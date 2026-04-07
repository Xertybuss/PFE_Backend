package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.ConstParameter;

public interface ConstParameterRepository extends JpaRepository<ConstParameter, Integer>{

    ConstParameter findConstParameterById(Integer id);

}

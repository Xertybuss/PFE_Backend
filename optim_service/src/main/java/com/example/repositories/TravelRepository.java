package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Travel;

public interface TravelRepository extends JpaRepository<Travel, Integer>{

}

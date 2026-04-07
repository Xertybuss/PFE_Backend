package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    Trip findTripById(Integer id);

}

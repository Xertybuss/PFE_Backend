package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Usage;

public interface UsageRepository extends JpaRepository<Usage, Integer>{

}

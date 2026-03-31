package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findProfileById(Integer id);

}

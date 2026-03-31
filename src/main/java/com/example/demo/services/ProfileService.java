package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Profile;

public interface ProfileService {
    public List<Profile> getAllProfiles();
    public Profile getProfileById(Integer id);
    public Profile createProfile(Profile profile);
    public Profile updateProfile(Profile profile);
    public void deleteProfile(Integer id);
}

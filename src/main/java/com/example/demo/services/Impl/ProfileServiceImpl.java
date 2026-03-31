package com.example.demo.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Profile;
import com.example.demo.repositories.ProfileRepository;
import com.example.demo.services.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
    private ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileById(Integer id) {
        return profileRepository.findProfileById(id);
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        Profile existingProfile = profileRepository.findProfileById(profile.getId());
        BeanUtils.copyProperties(profile, existingProfile, "id");
        return profileRepository.save(existingProfile);
    }

    @Override
    public void deleteProfile(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProfile'");
    }

    
}

package com.example.demo.controllers;

import com.example.demo.dtos.readDtos.ProfileReadDto;
import com.example.demo.dtos.writeUpdateDtos.ProfileWriteDto;
import com.example.demo.mappers.ProfileMapper;
import com.example.demo.services.ProfileService;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private ProfileService profileService;

    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/all")
    public List<ProfileReadDto> getAllProfiles() {
        return ProfileMapper.toDtoList(profileService.getAllProfiles());
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/get/{id}")
    public ProfileReadDto getProfileById(@PathVariable Integer id) {
        return ProfileMapper.toDto(profileService.getProfileById(id));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/create")
    public ProfileReadDto createProfile(@RequestBody ProfileWriteDto entity) {
        return ProfileMapper.toDto(profileService.createProfile(ProfileMapper.toEntity(entity)));
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/update")
    public ProfileReadDto updateProfile(@RequestBody ProfileWriteDto entity) {
        return ProfileMapper.toDto(profileService.updateProfile(ProfileMapper.toEntity(entity)));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteProfile(@PathVariable Integer id){
        profileService.deleteProfile(id);
    }
}

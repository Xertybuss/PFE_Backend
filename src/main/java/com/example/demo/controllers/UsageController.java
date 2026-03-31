package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.readDtos.UsageReadDto;
import com.example.demo.dtos.writeUpdateDtos.UsageWriteDto;
import com.example.demo.mappers.UsageMapper;
import com.example.demo.services.UsageService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usages")
public class UsageController {
    private UsageService usageService;

    public UsageController(UsageService usageService){
        this.usageService = usageService;
    }

    @GetMapping("/all")
    public List<UsageReadDto> getAllUsages() {
        return UsageMapper.toDtoList(usageService.getAllUsages());
    }
    
    @GetMapping("/get/{id}")
    public UsageReadDto getReadDto(@PathVariable Integer id) {
        return UsageMapper.toDto(usageService.getUsageById(id));
    }
    
    @PostMapping("/create")
    public UsageReadDto createUsage(@RequestBody UsageWriteDto entity) {
        return UsageMapper.toDto(usageService.createUsage(UsageMapper.toEntity(entity)));
    }

    @PutMapping("/update")
    public UsageReadDto updateUsage(@RequestBody UsageWriteDto entity) {
        return UsageMapper.toDto(usageService.updateUsage(UsageMapper.toEntity(entity)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsage(@PathVariable Integer id){
        usageService.deleteUsage(id);
    }
}

package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.readDtos.VehicleReadDto;
import com.example.demo.dtos.writeUpdateDtos.VehicleWriteDto;
import com.example.demo.exceptions.EmptyArrayException;
import com.example.demo.mappers.VehicleMapper;
import com.example.demo.services.VehicleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/all")
    public List<VehicleReadDto> getAllVehicles() {
        try {
            return VehicleMapper.toDtoList(vehicleService.getAllVehicles());
        } catch (EmptyArrayException e) {
            e.getMessage();
            return null;
        }
    }
    
    @GetMapping("/get/{id}")
    public VehicleReadDto getVehicleById(@PathVariable Integer id) {
        return VehicleMapper.toDto(vehicleService.getVehicleById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<VehicleReadDto> postMethodName(@RequestBody VehicleWriteDto entity) {
        return ResponseEntity.ok(VehicleMapper.toDto(vehicleService.createVehicle(VehicleMapper.toEntity(entity))));
    }

    @PutMapping("/update/{id}")
    public VehicleReadDto updateVehicle(@PathVariable Integer id, @RequestBody VehicleWriteDto entity) {       
        return VehicleMapper.toDto(vehicleService.updateVehicle(VehicleMapper.toEntity(entity)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable Integer id) {
        vehicleService.deleteVehicle(id);
    }
}
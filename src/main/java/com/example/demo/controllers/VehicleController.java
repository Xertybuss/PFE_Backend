package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.readDtos.VehicleReadDto;
import com.example.demo.mappers.VehicleMapper;
import com.example.demo.services.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    private VehicleMapper vehicleMapper = new VehicleMapper();

    @GetMapping("/get/{id}")
    public VehicleReadDto getVehicleById(@PathVariable int id) {
        return vehicleMapper.toDto(vehicleService.getVehicleById(id));
    }
}

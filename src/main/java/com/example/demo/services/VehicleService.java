package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Vehicle;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(int id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(int id);
}
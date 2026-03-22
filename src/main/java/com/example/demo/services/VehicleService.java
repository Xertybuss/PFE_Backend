package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Vehicle;
import com.example.demo.exceptions.EmptyArrayException;

public interface VehicleService {
    List<Vehicle> getAllVehicles() throws EmptyArrayException;
    Vehicle getVehicleById(Integer id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(Integer id);
}
package com.example.demo.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Vehicle;
import com.example.demo.repositories.VehicleRepository;
import com.example.demo.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    @Override
    public Vehicle getVehicleById(int id) {
        return vehicleRepository.findVehicleById(id);
    }
    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        Vehicle vehicle2 = vehicleRepository.findVehicleById(vehicle.getId());
        BeanUtils.copyProperties(vehicle, vehicle2, "id");  
        return vehicleRepository.save(vehicle2);
    }
    @Override
    public void deleteVehicle(int id) {
        vehicleRepository.deleteById(id);;
    }
}

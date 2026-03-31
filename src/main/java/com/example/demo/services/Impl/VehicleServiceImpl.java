package com.example.demo.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Vehicle;
import com.example.demo.exceptions.EmptyArrayException;
import com.example.demo.repositories.VehicleRepository;
import com.example.demo.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles() throws EmptyArrayException {
        if(vehicleRepository.findAll().isEmpty()) {
            throw new EmptyArrayException("List is empty");
        }
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findVehicleById(id);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    
    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findVehicleById(vehicle.getId());
        BeanUtils.copyProperties(vehicle, existingVehicle, "id");  
        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);;
    }
}

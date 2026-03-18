package com.example.demo.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dtos.readDtos.VehicleReadDto;
import com.example.demo.dtos.writeUpdateDtos.VehicleWriteDto;
import com.example.demo.entities.Vehicle;
import com.example.demo.enums.TypeVehicle;

import lombok.Data;

@Data
public class VehicleMapper {
    @Autowired
    private UsageMapper usageMapper;
    private String vehicle_type;

    public static Vehicle toEntity(VehicleWriteDto vehicleWriteDto){
        if(vehicleWriteDto == null) return null;
        Vehicle vehicle = new Vehicle();
        switch (vehicleWriteDto.getVehicle_type()) {
            case "Motorcycle":
                vehicle.setVehicle_type(TypeVehicle.MOTORCYCLE);
                break;
            case "Hatchback":
                vehicle.setVehicle_type(TypeVehicle.HATCHBACK);
                break;
            case "Sedan":
                vehicle.setVehicle_type(TypeVehicle.SEDAN);
                break;
            case "SUV":
                vehicle.setVehicle_type(TypeVehicle.SUV);
                break;
            case "Station wagon":
                vehicle.setVehicle_type(TypeVehicle.STATION_WAGON);
                break;
            case "Van":
                vehicle.setVehicle_type(TypeVehicle.VAN);
                break;
            case "Pickup":
                vehicle.setVehicle_type(TypeVehicle.PICKUP);
                break;
            default:
                break;
        }
        BeanUtils.copyProperties(vehicleWriteDto, vehicle, "vehicle_type");
        return vehicle;
    }

    public VehicleReadDto toDto(Vehicle vehicle){
        if(vehicle == null) return null;
        switch (vehicle.getVehicle_type()) {
            case TypeVehicle.MOTORCYCLE:
                this.setVehicle_type("Motorcycle");
                break;
        
            default:
                break;
        }
        return new VehicleReadDto(
            vehicle.getId(),
            vehicle.getImei(),
            vehicle.getImmatriculation(),
            vehicle.getLabel(),
            this.getVehicle_type(),
            vehicle.getCapacity_places(),
            vehicle.getCapacity_weight(),
            vehicle.getCompany().getId(),
            vehicle.getAccount_user().getId(),
            usageMapper.toDtoList(vehicle.getUsages())
        );
    }
}

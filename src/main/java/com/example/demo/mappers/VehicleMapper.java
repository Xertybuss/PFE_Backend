package com.example.demo.mappers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import com.example.demo.dtos.readDtos.VehicleReadDto;
import com.example.demo.dtos.writeUpdateDtos.VehicleWriteDto;
import com.example.demo.entities.Vehicle;
import com.example.demo.enums.TypeVehicle;

public class VehicleMapper {

    public static Vehicle toEntity(VehicleWriteDto vehicleWriteDto){
        if(vehicleWriteDto == null) return null;
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(TypeVehicle.fromLabel(vehicleWriteDto.getVehicleType()));
        BeanUtils.copyProperties(vehicleWriteDto, vehicle, "vehicleType", "id");
        return vehicle;
    }

    public static VehicleReadDto toDto(Vehicle vehicle){
        if(vehicle == null) return null;
        return new VehicleReadDto(
            vehicle.getId(),
            vehicle.getImei(),
            vehicle.getImmatriculation(),
            vehicle.getLabel(),
            vehicle.getVehicleType().getLabel(),
            vehicle.getCapacityPlaces(),
            vehicle.getCapacityWeight(),
            CompanyMapper.toDto(vehicle.getCompany()),
            AccountUserMapper.toReadDto(vehicle.getAccountUser()),
            UsageMapper.toDtoList(vehicle.getUsages())
        );
    }

    public static List<VehicleReadDto> toDtoList(List<Vehicle> vehicles){
        if(vehicles == null) return null;
        return vehicles.stream().map(VehicleMapper::toDto).toList();
    }
}

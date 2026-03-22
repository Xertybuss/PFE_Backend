package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.UsageReadDto;
import com.example.demo.dtos.writeUpdateDtos.UsageWriteDto;
import com.example.demo.entities.Usage;

@Mapper
public class UsageMapper {
    public static Usage toEntity(UsageWriteDto usageWriteDto){
        if(usageWriteDto == null) return null;
        Usage usage = new Usage();
        BeanUtils.copyProperties(usageWriteDto, usage);
        return usage;
    }

    public static UsageReadDto toDto(Usage usage){
        if(usage == null) return null;
        return new UsageReadDto(
            usage.getId(),
            usage.getDateStartAffectation(),
            usage.getDateEndAffectation(),
            usage.getStartHourMorning(),
            usage.getEndHourMorning(),
            usage.getStartHourEvening(),
            usage.getEndHourEvening(),
            CollaboraterMapper.toDto(usage.getCollaborater()),
            VehicleMapper.toDto(usage.getVehicle())
        );
    }

    public static List<UsageReadDto> toDtoList(List<Usage> usages){
        return usages.stream().map(UsageMapper::toDto).collect(Collectors.toList());
    }
}

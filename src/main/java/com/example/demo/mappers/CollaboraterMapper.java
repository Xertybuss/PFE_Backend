package com.example.demo.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.CollaboraterReadDto;
import com.example.demo.dtos.writeUpdateDtos.CollaboraterWriteDto;
import com.example.demo.entities.Collaborater;
import com.example.demo.enums.TypeCollab;

@Mapper
public class CollaboraterMapper {
    public static Collaborater toEntity(CollaboraterWriteDto collaboraterWriteDto){
        if (collaboraterWriteDto == null) return null;
        Collaborater collaborater = new Collaborater();
        collaborater.setCollabType(TypeCollab.fromLabel(collaboraterWriteDto.getCollabType()));
        BeanUtils.copyProperties(collaboraterWriteDto, collaborater, "collabType", "id");
        return collaborater;
    }

    public static CollaboraterReadDto toDto(Collaborater collaborater){
        if (collaborater == null) return null;
        return new CollaboraterReadDto(
            collaborater.getId(),
            collaborater.getFirstName(),
            collaborater.getLastName(),
            collaborater.getPhoneNumber(),
            collaborater.getHomeLocation(),
            collaborater.getAddress(),
            collaborater.getCollabType().getLabel(),
            CompanyMapper.toDto(collaborater.getCompany()),
            UsageMapper.toDtoList(collaborater.getUsages())
        );
    }

    public static List<CollaboraterReadDto> toDtoList(List<Collaborater> collaboraters){
        if (collaboraters == null) return null;
        return collaboraters.stream().map(CollaboraterMapper::toDto).toList();
    } 
}

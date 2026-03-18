package com.example.demo.mappers;

import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.CollaboraterReadDto;
import com.example.demo.dtos.writeUpdateDtos.CollaboraterWriteDto;
import com.example.demo.entities.Collaborater;

public class CollaboraterMapper {
    private String collab_type;

    public String getCollabType(){ return collab_type;}
    public void setCollabType(String val){ collab_type = val;}

    public static Collaborater toEntity(CollaboraterWriteDto collaboraterWriteDto){
        if(collaboraterWriteDto == null) return null;
        Collaborater collaborater = new Collaborater();
        BeanUtils.copyProperties(collaboraterWriteDto, collaborater);
        return collaborater;
    }

    public CollaboraterReadDto toDto(Collaborater collaborater){
        if(collaborater == null) return null;

        return null;
    }
}

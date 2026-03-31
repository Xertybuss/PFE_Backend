package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.readDtos.CollaboraterReadDto;
import com.example.demo.dtos.writeUpdateDtos.CollaboraterWriteDto;
import com.example.demo.exceptions.EmptyArrayException;
import com.example.demo.mappers.CollaboraterMapper;
import com.example.demo.services.CollaboraterService;

@RestController
@RequestMapping("/collaboraters")
public class CollaboraterController {
    private CollaboraterService collaboraterService;

    public CollaboraterController(CollaboraterService collaboraterService){
        this.collaboraterService = collaboraterService;
    }

    @PreAuthorize("hasRole('LOGISTICS')")
    @GetMapping("/all")
    public List<CollaboraterReadDto> getAllCollaboraters() {
        try {
            return CollaboraterMapper.toDtoList(collaboraterService.getAllCollaboraters());
        } catch (EmptyArrayException e) {
            e.getMessage();
            return null;
        }
    }
    
    @PreAuthorize("hasRole('LOGISTICS')")
    @GetMapping("/get/{id}")
    public CollaboraterReadDto getCollaboraterById(@PathVariable Integer id) {
        return CollaboraterMapper.toDto(collaboraterService.getCollaboraterById(id));
    }

    @PreAuthorize("hasRole('LOGISTICS')")
    @PostMapping("/create")
    public ResponseEntity<CollaboraterReadDto> postMethodName(@RequestBody CollaboraterWriteDto entity) {
        return ResponseEntity.ok(CollaboraterMapper.toDto(collaboraterService.createCollaborater(CollaboraterMapper.toEntity(entity))));
    }

    @PreAuthorize("hasRole('LOGISTICS')")
    @PutMapping("/update")
    public CollaboraterReadDto updateCollaborater(@RequestBody CollaboraterWriteDto entity) {       
        return CollaboraterMapper.toDto(collaboraterService.updateCollaborater(CollaboraterMapper.toEntity(entity)));
    }

    @PreAuthorize("hasRole('LOGISTICS')")
    @DeleteMapping("/delete/{id}")
    public void deleteCollaborater(@PathVariable Integer id) {
        collaboraterService.deleteCollaborater(id);
    }
}

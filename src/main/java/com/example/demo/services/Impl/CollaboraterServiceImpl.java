package com.example.demo.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Collaborater;
import com.example.demo.exceptions.EmptyArrayException;
import com.example.demo.repositories.CollaboraterRepository;
import com.example.demo.services.CollaboraterService;

@Service
public class CollaboraterServiceImpl implements CollaboraterService{
    private CollaboraterRepository collaboraterRepository;

    public CollaboraterServiceImpl(CollaboraterRepository collaboraterRepository){
        this.collaboraterRepository = collaboraterRepository;
    }

    @Override
    public List<Collaborater> getAllCollaboraters() throws EmptyArrayException {
        return collaboraterRepository.findAll();
    }

    @Override
    public Collaborater getCollaboraterById(Integer id) {
        return collaboraterRepository.findCollaboraterById(id);
    }

    @Override
    public Collaborater createCollaborater(Collaborater collaborater) {
        return collaboraterRepository.save(collaborater);
    }

    @Override
    public Collaborater updateCollaborater(Collaborater collaborater) {
        Collaborater existingCollaborater = collaboraterRepository.findCollaboraterById(collaborater.getId());
        BeanUtils.copyProperties(collaborater, existingCollaborater, "id");
        return collaboraterRepository.save(existingCollaborater);
    }

    @Override
    public void deleteCollaborater(Integer id) {
        collaboraterRepository.deleteById(id);
    }
}

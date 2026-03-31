package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Collaborater;
import com.example.demo.exceptions.EmptyArrayException;

public interface CollaboraterService {
    List<Collaborater> getAllCollaboraters() throws EmptyArrayException;
    Collaborater getCollaboraterById(Integer id);
    Collaborater createCollaborater(Collaborater collaborater);
    Collaborater updateCollaborater(Collaborater collaborater);
    void deleteCollaborater(Integer id);
}

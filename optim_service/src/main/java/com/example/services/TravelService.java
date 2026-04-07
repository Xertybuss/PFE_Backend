package com.example.services;

import java.util.List;

import com.example.entities.Travel;

public interface TravelService {
    public Travel getTravelById(Integer id);
    public List<Travel> getAllTravels();
    public Travel createTravel(Travel travel);
    public Travel updateTravel (Travel travel);
    public void deleteTravel(Integer id);
}

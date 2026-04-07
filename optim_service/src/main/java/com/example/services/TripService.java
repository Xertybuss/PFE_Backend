package com.example.services;

import java.util.List;

import com.example.entities.Trip;

public interface TripService {
    public Trip getTripById(Integer id);
    public List<Trip> getAllTrips();
    public Trip createTrip(Trip trip);
    public Trip updateTrip(Trip trip);
    public void deleteTrip(Integer id);
}

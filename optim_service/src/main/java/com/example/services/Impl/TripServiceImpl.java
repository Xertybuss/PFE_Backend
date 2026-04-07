package com.example.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.entities.Trip;
import com.example.repositories.TripRepository;
import com.example.services.TripService;

@Service
public class TripServiceImpl implements TripService{
    private TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip getTripById(Integer id) {
        return tripRepository.findTripById(id);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip updateTrip(Trip trip) {
        Trip existingTrip = tripRepository.findTripById(trip.getId());
        BeanUtils.copyProperties(trip, existingTrip, "id");
        return tripRepository.save(existingTrip);
    }

    @Override
    public void deleteTrip(Integer id) {
        tripRepository.deleteById(id);
    }

    
}

package com.parcel.service;

import com.parcel.model.api.request.CreateTripRequest;
import com.parcel.model.domain.ClassTruck;
import com.parcel.model.domain.order.ClassTrip;
import com.parcel.model.domain.order.TripStatus;
import com.parcel.model.domain.user.ClassUser;
import com.parcel.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final UserService userService;
    private final TruckService truckService;

    @Autowired
    public TripService(TripRepository tripRepository,
                       UserService userService,
                       TruckService truckService) {
        this.tripRepository = tripRepository;
        this.userService = userService;
        this.truckService = truckService;
    }

    public ClassTrip createTrip(CreateTripRequest request){

        ClassUser user = userService.fetchUser(request.getUser());
        ClassUser manager = userService.fetchUser(request.getUser());
        ClassTruck truck = truckService.fetchTruck(request.getTruck());

        ClassTrip trip = ClassTrip.builder()
                .start(request.getStart())
                .end(null)
                .deadline(request.getDeadline())
                .status(TripStatus.NEW)
                .driver(user)
                .manager(manager)
                .truck(truck)
                .build();

        return tripRepository.save(trip);
    }

    public List<ClassTrip> fetchTrips(Long id){
        if(id != null) {
            return tripRepository.findAllById(id);
        } else {
            return tripRepository.findAll();
        }
    }

    public ClassTrip fetchTrip(Long id){
        return tripRepository.findTripById(id);
    }
    public void updateTripInformation(Long id, LocalDate newStart, LocalDate newEnd) {
        if (newStart != null) {
            ClassTrip classTrip = tripRepository.findTripById(id);
            classTrip.setStart(newStart);
            tripRepository.save(classTrip);
        }
        if (newEnd != null) {
            ClassTrip classTrip = tripRepository.findTripById(id);
            classTrip.setStart(newEnd);
            tripRepository.save(classTrip);
        }
    }
    public void deleteTripByLogin(Long id) {
        ClassTrip classTrip = tripRepository.findTripById(id);
        tripRepository.deleteById(classTrip.getId());
    }
}

package com.parcel.service;

import com.parcel.model.api.request.CreateStopPointRequest;
import com.parcel.model.domain.order.ClassShipment;
import com.parcel.model.domain.order.ClassStopPoint;
import com.parcel.model.domain.order.ClassTrip;
import com.parcel.repository.StopPointRepository;
import com.parcel.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopPointService {

    private final ShipmentService shipmentService;
    private final TripService tripService;
    private final StopPointRepository stopPointRepository;


    @Autowired
    public StopPointService(ShipmentService shipmentService, TripService tripService, StopPointRepository stopPointRepository, TripRepository tripRepository) {
        this.shipmentService = shipmentService;
        this.tripService = tripService;
        this.stopPointRepository = stopPointRepository;
    }

    public ClassStopPoint createStopPoint(CreateStopPointRequest request) {
        ClassShipment shipment = shipmentService.fetchShipment(request.getShipment());
        ClassTrip trip = tripService.fetchTrip(request.getTrip());
        ClassStopPoint stopPoint = ClassStopPoint.builder()
                .stopDate(null)
                .shipment(shipment)
                .trip(trip)
                .build();
        return stopPointRepository.save(stopPoint);
    }

    public List<ClassStopPoint> fetchStopPoints(Long id, Long trip_id, Long shipment_id) {
        if (id != null) {
            return stopPointRepository.findAllById(id);
        } else if (trip_id != null){
            return stopPointRepository.findAll().stream().filter(stop -> stop.getTrip().getId().equals(trip_id)).toList();
        } else if (shipment_id != null){
            return stopPointRepository.findAll().stream().filter(stop -> stop.getShipment().getId().equals(shipment_id)).toList();
        }
        else{
            return stopPointRepository.findAll();
        }
    }

    public ClassStopPoint fetchStopPoint(Long id){
        return stopPointRepository.findStopPointById(id);
    }

    public void deleteStopPointByLogin(Long id) {
        ClassStopPoint classStopPoint = stopPointRepository.findStopPointById(id);
        stopPointRepository.deleteById(classStopPoint.getId());
    }
}

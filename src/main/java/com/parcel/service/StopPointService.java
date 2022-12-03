package com.parcel.service;

import com.parcel.model.api.request.CreateStopPointRequest;
import com.parcel.model.domain.order.ClassShipment;
import com.parcel.model.domain.order.ClassStopPoint;
import com.parcel.model.domain.order.ClassTrip;
import com.parcel.repository.StopPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopPointService {

    private final ShipmentService shipmentService;
    private final TripService tripService;
    private final StopPointRepository stopPointRepository;

    @Autowired
    public StopPointService(ShipmentService shipmentService, TripService tripService, StopPointRepository stopPointRepository) {
        this.shipmentService = shipmentService;
        this.tripService = tripService;
        this.stopPointRepository = stopPointRepository;
    }

    public ClassStopPoint createStopPoint(CreateStopPointRequest request) {
        ClassShipment shipment = shipmentService.fetchShipment(request.getShipment());
        ClassTrip trip = tripService.fetchTrip(request.getTrip());
        ClassStopPoint stopPoint = ClassStopPoint.builder()
                .nr(request.getNr())
                .stopDate(null)
                .shipment(shipment)
                .trip(trip)
                .build();
        return stopPointRepository.save(stopPoint);
    }

    public List<ClassStopPoint> fetchStopPoints(Long id) {
        if (id != null) {
            return stopPointRepository.findAllById(id);
        } else {
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

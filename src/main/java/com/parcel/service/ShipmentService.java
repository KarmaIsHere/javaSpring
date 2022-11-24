package com.parcel.service;

import com.parcel.model.api.request.CreateShipmentRequest;
import com.parcel.model.domain.order.ClassShipment;
import com.parcel.model.domain.order.ClassStopPoint;
import com.parcel.model.domain.order.ClassShipment;
import com.parcel.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public ClassShipment createShipment(CreateShipmentRequest request) {
        ClassShipment shipment = ClassShipment.builder()
                .description(request.getDescription())
                .weight(request.getWeight())
                .build();
        return shipmentRepository.save(shipment);
    }

    public List<ClassShipment> fetchShipments(Long id) {
        if (id != null) {
            return shipmentRepository.findAllById(id);
        } else {
            return shipmentRepository.findAll();
        }
    }

    public ClassShipment fetchShipment(Long id){
        return shipmentRepository.findShipmentById(id);
    }

    public void updateShipmentInformation(Long id, String newDescription, String newWeight) {
        if (newDescription != null) {
            ClassShipment classShipment = shipmentRepository.findShipmentById(id);
            classShipment.setDescription(newDescription);
            shipmentRepository.save(classShipment);
        }
        if (newWeight != null) {
            ClassShipment classShipment = shipmentRepository.findShipmentById(id);
            classShipment.setWeight(newWeight);
            shipmentRepository.save(classShipment);
        }
    }
    public void deleteShipmentByLogin(Long id) {
        ClassShipment classShipment = shipmentRepository.findShipmentById(id);
        shipmentRepository.deleteById(classShipment.getId());
    }
}

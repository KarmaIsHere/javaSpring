package com.parcel.repository;

import com.parcel.model.domain.order.ClassShipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<ClassShipment, Long> {
    List<ClassShipment> findAllById(Long id);
    ClassShipment findShipmentById(Long id);
}

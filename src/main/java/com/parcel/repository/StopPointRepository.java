package com.parcel.repository;

import com.parcel.model.domain.order.ClassStopPoint;
import com.parcel.model.domain.order.ClassTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StopPointRepository extends JpaRepository<ClassStopPoint, Long> {
    List<ClassStopPoint> findAllById(Long id);

    List<ClassStopPoint> findAllByTrip(Long tripId);
    ClassStopPoint findStopPointById(Long id);
}


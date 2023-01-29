package com.parcel.repository;

import com.parcel.model.domain.order.ClassStopPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StopPointRepository extends JpaRepository<ClassStopPoint, Long> {
    List<ClassStopPoint> findAllById(Long id);

    ClassStopPoint findStopPointById(Long id);
}


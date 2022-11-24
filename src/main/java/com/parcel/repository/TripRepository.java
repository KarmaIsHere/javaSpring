package com.parcel.repository;

import com.parcel.model.domain.order.ClassTrip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<ClassTrip, Long> {
    List<ClassTrip> findAllById(Long id);
}

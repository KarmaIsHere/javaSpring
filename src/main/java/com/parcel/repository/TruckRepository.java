package com.parcel.repository;

import com.parcel.model.domain.ClassTruck;
import com.parcel.model.domain.TruckStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TruckRepository extends JpaRepository<ClassTruck, Long> {
    List<ClassTruck> findAllById(Long id);
    List<ClassTruck> findAllByBrand(String brand);
    List<ClassTruck> findAllByStatus(TruckStatus status);
    ClassTruck findTruckById(Long id);
}

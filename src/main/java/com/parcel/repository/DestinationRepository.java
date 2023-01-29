package com.parcel.repository;

import com.parcel.model.domain.order.ClassDestination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<ClassDestination, Long> {
    List<ClassDestination> findAllById(Long id);
    List<ClassDestination> findAllByCountry(String country);
    List<ClassDestination> findAllByCity(String city);

    List<ClassDestination> findAllByStreetAddress(String streetAddress);
    ClassDestination findDestinationById(Long id);

}

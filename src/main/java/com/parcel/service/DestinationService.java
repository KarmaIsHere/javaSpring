package com.parcel.service;

import com.parcel.model.api.request.CreateDestinationRequest;
import com.parcel.model.domain.order.ClassDestination;
import com.parcel.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public ClassDestination createDestination(CreateDestinationRequest request) {
        ClassDestination destination = ClassDestination.builder()
                .country(request.getCountry())
                .city(request.getCity())
                .streetAddress(request.getStreetAddress())
                .build();
        return destinationRepository.save(destination);
    }

    public List<ClassDestination> fetchDestinations(Long id, String country, String city, String streetAddress) {
        if (id != null) {
            return destinationRepository.findAllById(id);
        } else if (country != null) {
            return destinationRepository.findAllByCountry(country);
        } else if (city != null) {
            return destinationRepository.findAllByCity(city);
        } else if (streetAddress != null) {
            return destinationRepository.findAllByStreetAddress(streetAddress);
        } else {
            return destinationRepository.findAll();
        }
    }

    public ClassDestination fetchDestination(Long id){
        return destinationRepository.findDestinationById(id);
    }

    public void updateDestinationInformation(Long id, String newCountry, String newCity, String newStreetAddress) {
        if (newCountry != null) {
            ClassDestination classDestination = destinationRepository.findDestinationById(id);
            classDestination.setCountry(newCountry);
            destinationRepository.save(classDestination);
        }
        if (newCity != null) {
            ClassDestination classDestination = destinationRepository.findDestinationById(id);
            classDestination.setCity(newCity);
            destinationRepository.save(classDestination);
        }
        if (newStreetAddress != null) {
            ClassDestination classDestination = destinationRepository.findDestinationById(id);
            classDestination.setStreetAddress(newStreetAddress);
            destinationRepository.save(classDestination);
        }
    }
    public void deleteDestinationByLogin(Long id) {
        ClassDestination classDestination = destinationRepository.findDestinationById(id);
        destinationRepository.deleteById(classDestination.getId());
    }
}

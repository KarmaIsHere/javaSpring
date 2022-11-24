package com.parcel.service;

import com.parcel.model.api.request.CreateTruckRequest;
import com.parcel.model.domain.ClassTruck;
import com.parcel.model.domain.TruckStatus;
import com.parcel.model.domain.user.ClassUser;
import com.parcel.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckService {

    private final TruckRepository truckRepository;

    @Autowired
    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public ClassTruck createTruck(CreateTruckRequest request) {
        ClassTruck truck = ClassTruck.builder()
                .brand(request.getBrand())
                .year(request.getYear())
                .height(request.getHeight())
                .weight(request.getWeight())
                .status(TruckStatus.FREE)
                .build();

        return truckRepository.save(truck);
    }

    public List<ClassTruck> fetchTrucks(Long id, String brand, TruckStatus status) {
        if (id != null) {
            return this.truckRepository.findAllById(id);
        } else if (brand != null) {
            return this.truckRepository.findAllByBrand(brand);
        } else if (status != null) {
            return this.truckRepository.findAllByStatus(status);
        } else {
            return this.truckRepository.findAll();
        }
    }

    public ClassTruck fetchTruck(Long id){
        return truckRepository.findTruckById(id);
    }

    public void updateTruckInformation(Long id, String newBrand, String newYear, String newHeight, String newWeight) {
        if (newBrand != null) {
            ClassTruck classTruck = truckRepository.findTruckById(id);
            classTruck.setBrand(newBrand);
            truckRepository.save(classTruck);
        }
        if (newYear != null) {
            ClassTruck classTruck = truckRepository.findTruckById(id);
            classTruck.setYear(newYear);
            truckRepository.save(classTruck);
        }
        if (newHeight != null) {
            ClassTruck classTruck = truckRepository.findTruckById(id);
            classTruck.setHeight(newHeight);
            truckRepository.save(classTruck);
        }
        if (newWeight != null) {
            ClassTruck classTruck = truckRepository.findTruckById(id);
            classTruck.setWeight(newWeight);
            truckRepository.save(classTruck);
        }
    }
    public void deleteTruckByLogin(Long id) {
        ClassTruck classTruck = truckRepository.findTruckById(id);
        truckRepository.deleteById(classTruck.getId());
    }
}

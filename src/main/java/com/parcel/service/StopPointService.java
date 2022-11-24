package com.parcel.service;

import com.parcel.model.domain.order.ClassStopPoint;
import com.parcel.model.domain.order.ClassTrip;
import com.parcel.repository.StopPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopPointService {

    private final StopPointRepository stopPointRepository;

    @Autowired
    public StopPointService(StopPointRepository stopPointRepository) {
        this.stopPointRepository = stopPointRepository;
    }

//    public ClassStopPoint createStopPoint(CreateStopPointRequest request) {
//        ClassStopPoint stopPoint = ClassStopPoint.builder();
//        return stopPointRepository.save(stopPoint);
//    }

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

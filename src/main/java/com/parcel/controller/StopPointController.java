package com.parcel.controller;

import com.parcel.model.api.response.StopPointResponse;
import com.parcel.service.StopPointService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.CacheRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/stopPoint")
public class StopPointController {

    private final StopPointService stopPointService;

    @Autowired
    public StopPointController(StopPointService stopPointService) {this.stopPointService = stopPointService;}

//    @PostMapping(path = "/create")
//    @Operation(summary = "Create new stopPoint in database")
//    public Long createStopPoint(@Validated @RequestBody CreateStopPointRequest request){
//        return stopPointService.createStopPoint(request).getId();
//    }

    @GetMapping(value = "/stopPoints")
    @Operation(summary = "Get stopPoints from database")
    public List<StopPointResponse> fetchStopPoints(@RequestParam(required = false) Long id){
        return stopPointService.fetchStopPoints(id).stream()
                .map(p -> new StopPointResponse(p.getId(), p.getNr(), p.getStopDate(), p.getShipment().getId(), p.getTrip().getId()))
                .collect(Collectors.toList());
    }
}

package com.parcel.controller;

import com.parcel.model.api.request.CreateTripRequest;
import com.parcel.model.api.response.TripResponse;
import com.parcel.service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/trip")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {this.tripService = tripService;}

    @PostMapping(path = "/create")
    @Operation(summary = "Create new trip in database")
    public Long createTrip(@Validated @RequestBody CreateTripRequest request){
        return tripService.createTrip(request).getId();
    }

    @GetMapping("/trips")
    @Operation(summary = "Get trips from database")
    public List<TripResponse> fetchTrips(@RequestParam(required = false) Long id){
        return tripService.fetchTrips(id).stream()
                .map(p -> new TripResponse(p.getId(), p.getStart(), p.getEnd(), p.getDriver().getId(), p.getTruck().getId()))
                .collect(Collectors.toList());
    }
}

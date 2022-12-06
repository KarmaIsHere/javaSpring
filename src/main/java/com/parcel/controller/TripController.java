package com.parcel.controller;

import com.parcel.model.api.request.CreateTripRequest;
import com.parcel.model.api.response.TripResponse;
import com.parcel.service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
                .map(p -> new TripResponse(p.getId(), p.getStart(), p.getDeadline(), p.getDriver().getId(), p.getTruck().getId()))
                .collect(Collectors.toList());
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete trip from database")
    public ResponseEntity<Void> deleteTripByLogin(@RequestParam Long id) {
        tripService.deleteTripByLogin(id);
        return ResponseEntity.noContent().build();
    }
//    @PutMapping(path = "/update")
//    @Operation(summary = "Update trip information")
//    public void updateTripLogin(@RequestParam String id,
//                                @RequestParam(required = false) String newStart,
//                                @RequestParam(required = false)
//                                )
//
//        this.tripService.updateTripInformation(login, newLogin, newEmail, newPassword, newFirstName, newLastName, newPhoneNumber, newSalary, newStatus, newAccountType);
//    }
}

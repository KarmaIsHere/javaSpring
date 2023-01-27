package com.parcel.controller;

import com.parcel.model.api.request.CreateTripRequest;
import com.parcel.model.api.response.TripResponse;
import com.parcel.model.domain.order.TripStatus;
import com.parcel.model.domain.user.UserAccountType;
import com.parcel.model.domain.user.UserStatus;
import com.parcel.service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<TripResponse> fetchTrips(@RequestParam(required = false) Long id,
                                         @RequestParam(required = false) Long userId,
                                         @RequestParam(required = false) Long managerId,
                                         @RequestParam(required = false) Long truckId)
    {
        return tripService.fetchTrips(id,  userId,  managerId,  truckId).stream()
                .map(p -> new TripResponse(p.getId(), p.getStart(), p.getEnd(), p.getDeadline(), p.getStatus(), p.getDriver().getId(), p.getManager().getId(), p.getTruck().getId()))
                .collect(Collectors.toList());
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete trip from database")
    public ResponseEntity<Void> deleteTripByLogin(@RequestParam Long id) {
        tripService.deleteTripByLogin(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update user information")
    public void updateUserLogin(@RequestParam Long id,
                                @RequestParam(required = false) LocalDate start,
                                @RequestParam(required = false) LocalDate end,
                                @RequestParam(required = false) TripStatus status) {
        this.tripService.updateTripInformation(id ,start, end, status);
    }

}

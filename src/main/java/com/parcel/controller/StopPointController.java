package com.parcel.controller;

import com.parcel.model.api.request.CreateStopPointRequest;
import com.parcel.model.api.response.StopPointResponse;
import com.parcel.service.StopPointService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/stopPoint")
public class StopPointController {

    private final StopPointService stopPointService;

    @Autowired
    public StopPointController(StopPointService stopPointService) {this.stopPointService = stopPointService;}

    @PostMapping(path = "/create")
    @Operation(summary = "Create new stopPoint in database")
    public Long createStopPoint(@Validated @RequestBody CreateStopPointRequest request){
        return stopPointService.createStopPoint(request).getId();
    }

    @GetMapping(value = "/stopPoints")
    @Operation(summary = "Get stopPoints from database")
    public List<StopPointResponse> fetchStopPoints(@RequestParam(required = false) Long id,
                                                   @RequestParam(required = false) Long trip_id,
                                                   @RequestParam(required = false) Long shipment_id){


        return stopPointService.fetchStopPoints(id, trip_id, shipment_id).stream()
                .map(p -> new StopPointResponse(p.getId(), p.getStopDate(), p.getShipment().getId(), p.getTrip().getId()))
                .collect(Collectors.toList());
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete stopPoint from database")
    public ResponseEntity<Void> deleteStopPointByLogin(@RequestParam Long id) {
        stopPointService.deleteStopPointByLogin(id);
        return ResponseEntity.noContent().build();
    }
}

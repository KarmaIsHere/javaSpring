package com.parcel.controller;

import com.parcel.model.api.request.CreateDestinationRequest;
import com.parcel.model.api.response.DestinationResponse;
import com.parcel.service.DestinationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/destination")
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {this.destinationService = destinationService;}

    @PostMapping(path = "/create")
    @Operation(summary = "Create new destination in database")
    public Long createDestination(@Validated @RequestBody CreateDestinationRequest request){
        return destinationService.createDestination(request).getId();
    }

    @GetMapping(value = "/destinations")
    @Operation(summary = "Get destinations from database")
    public List<DestinationResponse> fetchDestinations(@RequestParam(required = false) Long id,
                                                       @RequestParam(required = false) String country,
                                                       @RequestParam(required = false) String city,
                                                       @RequestParam(required = false) String streetAddress) {

        return destinationService.fetchDestinations(id, country, city, streetAddress).stream()
                .map(p -> new DestinationResponse(p.getId() ,p.getCountry(), p.getCity(), p.getStreetAddress()))
                .collect(Collectors.toList());
    }
    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete destination from database")
    public ResponseEntity<Void> deleteDestinationByLogin(@RequestParam Long id) {
        destinationService.deleteDestinationByLogin(id);
        return ResponseEntity.noContent().build();
    }
}

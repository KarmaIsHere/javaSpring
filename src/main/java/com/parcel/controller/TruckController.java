package com.parcel.controller;

import com.parcel.model.api.request.CreateTruckRequest;
import com.parcel.model.api.response.TruckResponse;
import com.parcel.model.domain.TruckStatus;
import com.parcel.service.TruckService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/truck")
public class TruckController {

    private final TruckService truckService;

    @Autowired
    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create new truck in database")
    public Long createTruck(@Validated @RequestBody CreateTruckRequest request) {
        return truckService.createTruck(request).getId();
    }

    @GetMapping(value = "/trucks")
    @Operation(summary = "Get trucks from database")
    public List<TruckResponse> fetchTrucks(@RequestParam(required = false) Long id,
                                             @RequestParam(required = false) String brand,
                                             @RequestParam(required = false) TruckStatus status) {
        return truckService.fetchTrucks(id, brand, status).stream()
                .map(p -> new TruckResponse(p.getId(), p.getBrand(), p.getYear(), p.getHeight(), p.getWeight(), p.getStatus()))
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update truck information")
    public void updateUserLogin(@RequestParam Long id,
                                @RequestParam(required = false) String newBrand,
                                @RequestParam(required = false) String newYear,
                                @RequestParam(required = false) String newHeight,
                                @RequestParam(required = false) String newWeight) {
        this.truckService.updateTruckInformation(id, newBrand, newYear, newHeight, newWeight);
    }
}

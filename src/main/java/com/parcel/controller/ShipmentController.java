package com.parcel.controller;

import com.parcel.model.api.request.CreateShipmentRequest;
import com.parcel.model.api.response.ShipmentResponse;
import com.parcel.service.ShipmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.CacheRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {this.shipmentService = shipmentService;}

    @PostMapping(path = "/create")
    @Operation(summary = "Create new shipment in database")
    public Long createShipment(@Validated @RequestBody CreateShipmentRequest request){
        return shipmentService.createShipment(request).getId();
    }

    @GetMapping(value = "/shipments")
    @Operation(summary = "Get shipments from database")
    public List<ShipmentResponse> fetchShipments(@RequestParam(required = false) Long id){
        return shipmentService.fetchShipments(id).stream()
                .map(p -> new ShipmentResponse(p.getId() ,p.getDescription(), p.getWeight(), p.getDestination().getId()))
                .collect(Collectors.toList());
    }
}

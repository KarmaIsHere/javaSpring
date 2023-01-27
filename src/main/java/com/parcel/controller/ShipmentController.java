package com.parcel.controller;

import com.parcel.model.api.request.CreateShipmentRequest;
import com.parcel.model.api.response.ShipmentResponse;
import com.parcel.model.domain.order.ShipmentStatus;
import com.parcel.model.domain.order.TripStatus;
import com.parcel.service.ShipmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<ShipmentResponse> fetchShipments(@RequestParam(required = false) Long id,
                                                 @RequestParam(required = false) Long destinationId){
        return shipmentService.fetchShipments(id, destinationId).stream()
                .map(p -> new ShipmentResponse(p.getId() ,p.getStatus(), p.getDescription(), p.getWeight(), p.getDestination().getId()))
                .collect(Collectors.toList());
    }
    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete shipment from database")
    public ResponseEntity<Void> deleteShipmentByLogin(@RequestParam Long id) {
        shipmentService.deleteShipmentByLogin(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update user information")
    public void updateUserLogin(@RequestParam Long id,
                                @RequestParam(required = false) String description,
                                @RequestParam(required = false) String weight,
                                @RequestParam(required = false) ShipmentStatus status) {
        this.shipmentService.updateShipmentInformation(id ,description, weight, status);
    }
}

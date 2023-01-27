package com.parcel.model.api.response;

import com.parcel.model.domain.order.ShipmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShipmentResponse {

    @Schema(description = "Shipment id", example = "1")
    private Long id;

    @Schema(description = "Shipment status", example = "NEW")
    private ShipmentStatus status;

    @Schema(description = "Short shipment description", example = "T-shirts")
    private String description;

    @Schema(description = "Shipment weight", example = "2000kg")
    private String weight;

    @Schema(description = "Shipment destination", example = "1")
    private Long destinationId;
}

package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class StopPointResponse {

    @Schema(description = "StopPoint id", example = "1")
    private Long id;



    @Schema(description = "Date and time when stop was reached", example = "2022-12-06")
    private LocalDate stopDate;

    @Schema(description = "Shipment that needs to be delivered to this stop point", example = "2000kg")
    private Long shipmentId;

    @Schema(description = "Stop points assigned trip", example = "1")
    private Long tripId;
}

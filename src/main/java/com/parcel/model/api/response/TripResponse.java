package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class TripResponse {
    @Schema(description = "Trip id", example = "144")
    private Long id;

    @Schema(description = "Trip start date", example = "1")
    private Timestamp start;

    @Schema(description = "Trip finish date", example = "1")
    private Timestamp end;

    @Schema(description = "Trip user id", example = "1")
    private Long userId;

    @Schema(description = "Trip truck id", example = "12")
    private Long truckId;
}

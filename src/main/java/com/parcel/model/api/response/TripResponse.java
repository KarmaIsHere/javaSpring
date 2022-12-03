package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TripResponse {
    @Schema(description = "Trip id", example = "144")
    private Long id;

    @Schema(description = "Trip start date", example = "1")
    private LocalDate start;

    @Schema(description = "Trip finish date", example = "1")
    private LocalDate end;

    @Schema(description = "Trip deadline", example = "1")
    private LocalDate deadline;

    @Schema(description = "Trip user id", example = "1")
    private Long userId;

    @Schema(description = "Trip truck id", example = "12")
    private Long truckId;
}

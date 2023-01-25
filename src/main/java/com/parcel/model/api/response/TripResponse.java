package com.parcel.model.api.response;

import com.parcel.model.domain.order.TripStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TripResponse {
    @Schema(description = "Trip id", example = "1")
    private Long id;

    @Schema(description = "Trip start date", example = "2022-12-06")
    private LocalDate start;

    @Schema(description = "Trip end date", example = "2022-12-06")
    private LocalDate end;

    @Schema(description = "Trip deadline", example = "2022-12-06")
    private LocalDate deadline;

    @Schema(description = "Trip status", example = "NEW")
    private TripStatus status;

    @Schema(description = "Trip user id", example = "1")
    private Long user;

    @Schema(description = "Trip responsible manager id", example = "1")
    private Long manager;

    @Schema(description = "Trip truck id", example = "1")
    private Long truck;
}

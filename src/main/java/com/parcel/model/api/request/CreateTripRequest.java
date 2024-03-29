package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CreateTripRequest {

    @NonNull
    @Schema(description = "Trip user id", example = "1")
    private Long user;

    @NonNull
    @Schema(description = "Trip responsible manager id", example = "1")
    private Long manager;

    @NonNull
    @Schema(description = "Trip truck id", example = "1")
    private Long truck;
    @NonNull
    @Schema(description = "Trip deadline", example = "2022-12-06")
    private LocalDate deadline;
    
}

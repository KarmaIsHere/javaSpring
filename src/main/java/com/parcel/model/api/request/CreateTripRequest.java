package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class CreateTripRequest {

    @NonNull
    @Schema(description = "Trip user id", example = "1")
    private Long userId;
    @NonNull
    @Schema(description = "Trip truck id", example = "12")
    private Long truckId;
    
}

package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class CreateStopPointRequest {

    @NonNull
    @Schema(description = "Shipment shipment", example = "1")
    private Long shipment;
    @NonNull
    @Schema(description = "Shipment trip", example = "1")
    private Long trip;
}

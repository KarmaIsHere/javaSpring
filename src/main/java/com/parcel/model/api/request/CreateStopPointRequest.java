package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateStopPointRequest {

    @NonNull
    @Size(max = 30)
    @Schema(description = "Short shipment description", example = "1")
    private int nr;
    @NonNull
    @Schema(description = "Shipment shipment", example = "1")
    private Long shipment;
    @NonNull
    @Schema(description = "Shipment trip", example = "1")
    private Long trip;
}

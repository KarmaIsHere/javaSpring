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
    @Schema(description = "Short shipment description", example = "T-shirts")
    private int nr;
    @NonNull
    @Schema(description = "Shipment weight", example = "400kg")
    private Long shipment;
    @NonNull
    @Schema(description = "Shipment destination", example = "1")
    private Long trip;
}

package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateDestinationRequest {

    @NonNull
    @Size(max = 30)
    @Schema(description = "Destination country", example = "USA")
    private String country;

    @NonNull
    @Size(max = 30)
    @Schema(description = "Destination city", example = "New York")
    private String city;

    @NonNull
    @Size(max = 70)
    @Schema(description = "Destination street address", example = "7862 Homestead St. Astoria, NY 11103")
    private String streetAddress;
}

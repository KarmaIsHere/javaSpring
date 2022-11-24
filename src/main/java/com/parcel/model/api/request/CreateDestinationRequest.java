package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateDestinationRequest {

    @Size(max = 30)
    @NonNull
    @Schema(name = "Destination country", example = "USA")
    private String country;

    @Size(max = 30)
    @NonNull
    @Schema(name = "Destination city", example = "New York")
    private String city;

    @Size(max = 70)
    @NonNull
    @Schema(name = "Destination street address", example = "7862 Homestead St. Astoria, NY 11103")
    private String streetAddress;
}

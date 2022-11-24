package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class DestinationResponse {

    @Schema(description = "Destination id", example = "1")
    private Long id;

    @Schema(name = "Destination country", example = "USA")
    private String country;

    @Schema(name = "Destination city", example = "New York")
    private String city;

    @Schema(name = "Destination street address", example = "7862 Homestead St. Astoria, NY 11103")
    private String streetAddress;
}

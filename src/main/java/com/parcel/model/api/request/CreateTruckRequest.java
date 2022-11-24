package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class CreateTruckRequest {
    @NonNull
    @Schema(description = "Truck brand", example = "Toyota")
    private String brand;
    @NonNull
    @Schema(description = "Truck year", example = "2011")
    private String year;
    @NonNull
    @Schema(description = "Truck height", example = "4.7 m")
    private String height;
    @NonNull
    @Schema(description = "Truck weight", example = "11.5 t")
    private String weight;
}

package com.parcel.model.api.response;

import com.parcel.model.domain.TruckStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TruckResponse {

    @Schema(description = "Truck id", example = "2")
    private Long id;

    @Schema(description = "Truck brand", example = "Toyota")
    private String brand;

    @Schema(description = "Truck year", example = "2011")
    private String year;

    @Schema(description = "Truck height", example = "4.7 m")
    private String height;

    @Schema(description = "Truck weight", example = "11.5 t")
    private String weight;

    @Schema(description = "Truck status", example = "WORKING")
    private TruckStatus status;

}

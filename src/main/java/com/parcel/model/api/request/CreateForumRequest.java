package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;
@Data
@AllArgsConstructor
public class CreateForumRequest {

    @NonNull
    @Schema(description = "title", example = "Where has Bob Roger been?")
    private String title;

    @Schema(description = "description", example = "Truck")
    private String description;

    @NonNull
    @Schema(description = "category", example = "Truck")
    private String category;

    @NonNull
    @Schema(description = "creator", example = "1")
    private Long user;
}

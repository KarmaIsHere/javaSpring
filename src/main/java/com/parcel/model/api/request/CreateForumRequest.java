package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
public class CreateForumRequest {

    @NonNull
    @Schema(description = "Forum title", example = "Where has Bob Roger been?")
    private String title;

    @Schema(description = "Forum description", example = "Truck")
    private String description;

    @NonNull
    @Schema(description = "Forum category", example = "Truck")
    private String category;

    @NonNull
    @Schema(description = "Forum creator", example = "1")
    private Long userId;
}

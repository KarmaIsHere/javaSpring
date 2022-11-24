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
    @Schema(name = "Forum title", example = "Where has Bob Roger been?")
    private String title;

    @Schema(name = "Forum description", example = "Truck")
    private String description;

    @NonNull
    @Schema(name = "Forum category", example = "Truck")
    private String category;

    @NonNull
    @Schema(name = "Forum creator", example = "John Smith")
    private Long userId;
}

package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ForumResponse {

    @Schema(name = "Forum id", example = "1")
    private Long id;

    @Schema(name = "Forum title", example = "Where has Bob Roger been?")
    private String title;

    @Schema(name = "Forum description", example = "Has anybody seen Bob for the past week?")
    private String description;

    @Schema(name = "Forum category", example = "Truck")
    private String category;

    @Schema(name = "Forum creator", example = "John Smith")
    private Long user;

    @Schema(name = "Forum creation date")
    private Instant date;

}

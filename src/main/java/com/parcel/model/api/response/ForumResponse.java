package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ForumResponse {

    @Schema(name = "id", example = "1")
    private Long id;

    @Schema(name = "title", example = "Where has Bob Roger been?")
    private String title;

    @Schema(name = "description", example = "Has anybody seen Bob for the past week?")
    private String description;

    @Schema(name = "category", example = "Truck")
    private String category;

    @Schema(name = "creator", example = "John Smith")
    private Long user;

    @Schema(name = "creationDate")
    private LocalDate date;

}

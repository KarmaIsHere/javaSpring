package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CommentResponse {
    @Schema(description = "Comment id", example = "1")
    private Long id;

    @Schema(description = "Comment text", example = "I got stopped by the police")
    private String text;

    @Schema(description = "Comment date")
    private LocalDate date;

    @Schema(description = "Comment forum", example = "1")
    private Long forum;

    @Schema(description = "Comment user", example = "1")
    private Long user;
}

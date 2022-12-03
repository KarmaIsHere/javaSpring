package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
public class CreateCommentRequest {

    @NonNull
    @Schema(description = "Comment content", example = "I got stopped by the police")
    private String text;
    @NonNull
    @Schema(description = "Comment creator", example = "1")
    private Long user;
    @NonNull
    @Schema(description = "Comment forum", example = "1")
    private Long forum;
}

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
    @Schema(name = "Comment content", example = "I got stopped by the police")
    private String text;
    @NonNull
    @Schema(name = "Comment creator", example = "John Smith")
    private Long user;
}

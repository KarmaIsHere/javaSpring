package com.parcel.model.api.response;

import com.parcel.model.domain.forum.ClassForum;
import com.parcel.model.domain.user.ClassUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;

@Data
@AllArgsConstructor
public class CommentResponse {
    @Schema(description = "Comment id", example = "543")
    private Long id;

    @Schema(description = "Comment text", example = "I got stopped by the police")
    private String text;

    @Schema(description = "Comment date", example = "1")
    private Instant date;

    @Schema(description = "Comment forum", example = "23")
    private ClassForum forumId;

    @Schema(description = "Comment user", example = "2")
    private ClassUser creatorId;
}

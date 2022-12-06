package com.parcel.controller;

import com.parcel.model.api.request.CreateCommentRequest;
import com.parcel.model.api.response.CommentResponse;
import com.parcel.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create new comment in database")
    public Long createComment(@Validated @RequestBody CreateCommentRequest request) {
        return commentService.createComment(request).getId();
    }

    @GetMapping(value = "/comments")
    @Operation(summary = "Get comments from database")
    public List<CommentResponse> fetchComments(@RequestParam(required = false) Long id,
                                               @RequestParam(required = false) Long forumId,
                                               @RequestParam(required = false) String text
                                               ) {
        return commentService.fetchComments(id,forumId, text).stream()
                .map(p -> new CommentResponse(p.getId(), p.getText(), p.getDate(), p.getForum().getId(), p.getUser().getId()))
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update comment information")
    public void updateCommentText( @RequestParam Long id,
                                   @RequestParam String text,
                                   @RequestParam(required = false) String newText) {
        this.commentService.updateCommentInformation(id,text, newText);
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete comment from database")
    public ResponseEntity<Void> deleteCommentById(@RequestParam Long id) {
        commentService.deleteCommentById(id);
        return ResponseEntity.noContent().build();
    }

}
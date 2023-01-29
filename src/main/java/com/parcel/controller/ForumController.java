package com.parcel.controller;

import com.parcel.model.api.request.CreateForumRequest;
import com.parcel.model.api.response.ForumResponse;
import com.parcel.service.ForumService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/forum")
public class ForumController {

    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create new forum in database")
    public Long createForum(@Validated @RequestBody CreateForumRequest request) {
        return forumService.createForum(request).getId();
    }

    @GetMapping(value = "/forums")
    @Operation(summary = "Get forums from database")
    public List<ForumResponse> fetchForums(@RequestParam(required = false) Long id)
    {
        return forumService.fetchForums(id).stream()
                .map(p -> new ForumResponse(p.getId(), p.getTitle(), p.getDescription(), p.getCategory(), p.getCreator().getId(), p.getDate()))
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update forum information")
    public void updateForumText( @RequestParam Long id,
                                 @RequestParam(required = false) String newTitle,
                                 @RequestParam(required = false) String newDescription,
                                 @RequestParam(required = false) String newCategory){
        this.forumService.updateForumInformation(id,newTitle, newDescription, newCategory);
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete forum from database")
    public ResponseEntity<Void> deleteForumById(@RequestParam Long id) {
        forumService.deleteForumById(id);
        return ResponseEntity.noContent().build();
    }

}
package com.parcel.service;

import com.parcel.model.api.request.CreateCommentRequest;
import com.parcel.model.domain.forum.ClassComment;
import com.parcel.model.domain.forum.ClassForum;
import com.parcel.model.domain.user.ClassUser;
import com.parcel.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ClassComment createComment(CreateCommentRequest request) {
        Instant now = Instant.now();
        //ClassForum user = forumService.fetchFprum(request.getForumId());
        ClassComment comment = ClassComment.builder()
                .text(request.getText())
                .date(now)
                .build();
        return commentRepository.save(comment);
    }

    public List<ClassComment> fetchComments(Long id, Long forumId, String text) {
        if (id != null) {
            return this.commentRepository.findAllById(id);
        } else if (forumId != null) {
            return this.commentRepository.findAllByForumId(forumId);
        } else {
            return this.commentRepository.findAll();
        }
    }

    public ClassComment fetchComment(Long id) {
        return commentRepository.findCommentById(id);
    }

    public void updateCommentInformation(Long id, String text, String newText) {
        if (newText != null) {
            ClassComment classComment = commentRepository.findCommentById(id);
            classComment.setText(newText);
            commentRepository.save(classComment);
        }
    }

    public void deleteCommentById(Long id) {
        ClassComment classComment = commentRepository.findCommentById(id);
        commentRepository.deleteById(classComment.getId());
    }
}
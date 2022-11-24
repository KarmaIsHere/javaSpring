package com.parcel.repository;

import com.parcel.model.domain.forum.ClassComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<ClassComment, Long> {
    List<ClassComment> findAllById(Long id);
    List<ClassComment> findAllByForumId(Long forumId);
    ClassComment findCommentById(Long id);

    ClassComment findCommentByText(String text);
}

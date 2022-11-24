package com.parcel.repository;

import com.parcel.model.domain.forum.ClassForum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForumRepository extends JpaRepository<ClassForum, Long> {
    List<ClassForum> findAllById(Long id);
    List<ClassForum> findAllByCategory(Long forumId);
    ClassForum findForumById(Long id);

}

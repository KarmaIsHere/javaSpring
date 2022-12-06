package com.parcel.service;

import com.parcel.model.api.request.CreateForumRequest;
import com.parcel.model.domain.forum.ClassForum;
import com.parcel.model.domain.user.ClassUser;
import com.parcel.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ForumService {
    private final UserService userService;
    private final ForumRepository forumRepository;

    @Autowired
    public ForumService(UserService userService, ForumRepository forumRepository) {
        this.userService = userService;
        this.forumRepository = forumRepository;
    }

    public ClassForum createForum(CreateForumRequest request) {
        Instant now = Instant.now();
        ClassUser user = userService.fetchUser(request.getUser());
        ClassForum forum = ClassForum.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .creator(user)
                .category(request.getCategory())
                .date(now).build();
        return forumRepository.save(forum);
    }

    public List<ClassForum> fetchForums(Long id, Long forumId, String text) {
        if (id != null) {
            return this.forumRepository.findAllById(id);
        } //else if (forumId != null) {
            //return this.forumRepository.findAllByCategory(forumId);
        else {
            return this.forumRepository.findAll();
        }
    }

    public ClassForum fetchForum(Long id) {
        return forumRepository.findForumById(id);
    }

    public void updateForumInformation(Long id, String newTitle, String newDescription, String newCategory) {
        if (newTitle != null) {
            ClassForum classForum = forumRepository.findForumById(id);
            classForum.setTitle(newTitle);
            forumRepository.save(classForum);
        }
        if (newDescription != null) {
            ClassForum classForum = forumRepository.findForumById(id);
            classForum.setDescription(newDescription);
            forumRepository.save(classForum);
        }
        if (newCategory != null) {
            ClassForum classForum = forumRepository.findForumById(id);
            classForum.setCategory(newCategory);
            forumRepository.save(classForum);
        }
    }

    public void deleteForumById(Long id) {
        ClassForum classForum = forumRepository.findForumById(id);
        forumRepository.deleteById(classForum.getId());
    }
}
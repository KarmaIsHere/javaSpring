package com.parcel.model.domain.forum;

import com.parcel.model.domain.user.ClassUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "Forums")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassForum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORUM_ID", nullable = false)
    private Long id;

    @Column(name = "FORUM_TITLE", nullable = false)
    private String title;

    @Column(name = "FORUM_DESCRIPTION")
    private String description;

    @Column(name = "FORUM_CATEGORY")
    private String category;

    @OneToMany(mappedBy = "forum")
    private List<ClassComment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private ClassUser creator;

    @Column(name = "FORUM_CREATIONDATE", nullable = false)
    private LocalDate date;





}

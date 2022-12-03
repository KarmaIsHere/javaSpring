package com.parcel.model.domain.forum;

import com.parcel.model.domain.user.ClassUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity(name = "Comments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID", nullable = false)
    private Long id;

    @Column(name = "COMMENT_CONTENT", nullable = false)
    private String text;

    @Column(name = "COMMENT_DATE", nullable = false)
    private Instant date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FORUM_ID", nullable = false)
    private ClassForum forum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private ClassUser user;

}

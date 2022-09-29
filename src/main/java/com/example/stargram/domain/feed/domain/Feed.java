package com.example.stargram.domain.feed.domain;


import com.example.stargram.domain.user.domain.User;
import com.example.stargram.global.entity.BaseTimeEntity;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Table(name = "FeedTbl")
@Entity
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(length = 30)
    private String title;

    @NotNull
    private String content;

    @NotNull
    @Column(length = 10)
    private String category;

    private int heartCount;

    private int commentCount;

    @Builder
    public Feed(String title, String content, String category, User user, int heartCount, int commentCount) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.user = user;
        this.heartCount = heartCount;
        this.commentCount = commentCount;
    }

    public void updateFeed(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addHeartCount() {
        this.heartCount++;
    }

    public void removeHeartCount() {
        this.heartCount--;
    }

    public void addCommentCount() {
        this.commentCount++;
    }

    public void removeCommentCount() {
        this.commentCount--;
    }

}

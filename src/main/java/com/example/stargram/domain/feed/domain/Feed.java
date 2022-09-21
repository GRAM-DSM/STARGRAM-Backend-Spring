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
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(32)")
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

    @Builder
    public Feed (String title, String content, String category, User user){
        this.title = title;
        this.content = content;
        this.category = category;
        this.user = user;
    }

    public void updateFeed(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

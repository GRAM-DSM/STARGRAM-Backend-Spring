package com.example.stargram.domain.comment.domain;


import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.global.entity.BaseTimeEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    private String content;
}

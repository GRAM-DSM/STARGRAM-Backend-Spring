package com.example.stargram.domain.feed.domain;


import com.example.stargram.domain.user.domain.User;
import com.example.stargram.global.entity.BaseTimeEntity;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, columnDefinition = "BINARY(16)")
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
}

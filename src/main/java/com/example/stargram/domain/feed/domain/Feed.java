package com.example.stargram.domain.feed.domain;


import com.example.stargram.domain.user.domain.User;
import com.example.stargram.global.entity.BaseTimeEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BINARY(16)")
    private long id;

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
}

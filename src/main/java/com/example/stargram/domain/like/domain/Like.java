package com.example.stargram.domain.like.domain;

import com.example.stargram.domain.feed.domain.Feed;
import com.example.stargram.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Getter
@NoArgsConstructor
@Entity
public class Like {

    @Id
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    private Feed feed;
}

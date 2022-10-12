package com.example.stargram.domain.profile.domain;


import com.example.stargram.domain.user.domain.User;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Profile {

    @Column(columnDefinition = "VARCHAR(5)")
    @Id
    private String name;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    private String introduce;

    @NotNull
    @Column(columnDefinition = "VACHAR(300)")
    private String photo;

    @NotNull
    private String link;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}

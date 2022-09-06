package com.example.stargram.domain.user.domain;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 10)
    private String account_id;

    @NotNull
    @Column(length = 320)
    private String email;

    @NotNull
    @Column(length = 256)
    private String password;

    @NotNull
    @Column(length = 5)
    private String name;

    @NotNull
    @Column(length = 30)
    private String introduce;

    @NotNull
    @Column(length = 300)
    private String photo;

    @Null
    private String link;

}

package com.example.stargram.domain.user.domain;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    private String accountId;

    @NotNull
    @Column(columnDefinition = "VARCHAR(320)")
    private String email;

    @NotNull
    @Column(columnDefinition = "VARCHAR(256)")
    private String password;

    @NotNull
    @Column(columnDefinition = "VARCHAR(5)")
    private String name;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    private String introduce;

    @NotNull
    @Column(columnDefinition = "VARCHAR(300)")
    private String photo;

    private String link;

}

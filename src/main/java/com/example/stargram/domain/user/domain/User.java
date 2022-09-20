package com.example.stargram.domain.user.domain;


import com.example.stargram.global.enums.Authority;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
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
    @Column(columnDefinition = "VARCHAR(10)", unique = true)
    private String accountId;

    @NotNull
    @Column(columnDefinition = "VARCHAR(320)")
    private String email;

    @NotNull
    @Column(columnDefinition = "VARCHAR(60)")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String email, String accountId, String password) {
        this.email = email;
        this.accountId = accountId;
        this.password = password;
    }

}

package com.example.stargram.domain.image.domain;


import com.example.stargram.domain.user.domain.User;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Table(name = "PhotoTbl")
@Entity
public class Image {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(32)")
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(columnDefinition = "VARCHAR(300)")
    private String url;

    @Builder
    public Image (User user, String url) {
        this.user = user;
        this.url = url;
    }
}

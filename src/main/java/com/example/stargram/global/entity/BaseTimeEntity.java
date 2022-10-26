package com.example.stargram.global.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;



@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {

    @Column(nullable = false)
    private final ZonedDateTime CreateAt = ZonedDateTime.now();

}
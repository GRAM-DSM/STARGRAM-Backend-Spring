package com.example.stargram.domain.like.domain.repository;

import com.example.stargram.domain.like.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface LikeRepository extends JpaRepository <Like, BigInteger> {
}

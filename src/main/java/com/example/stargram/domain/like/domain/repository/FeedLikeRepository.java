package com.example.stargram.domain.like.domain.repository;

import com.example.stargram.domain.like.domain.FeedLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FeedLikeRepository extends JpaRepository <FeedLike, BigInteger> {
}

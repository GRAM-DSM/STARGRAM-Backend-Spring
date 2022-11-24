package com.example.stargram.domain.image.domain.repository;

import com.example.stargram.domain.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
    List<Image> findAllByFeed_Id(UUID feedId);
}

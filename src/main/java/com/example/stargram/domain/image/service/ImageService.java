package com.example.stargram.domain.image.service;

import com.example.stargram.domain.image.domain.Image;
import com.example.stargram.domain.image.domain.repository.ImageRepository;
import com.example.stargram.domain.image.presentation.dto.response.ImageUrlResponse;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.facade.UserFacade;
import com.example.stargram.global.annotation.ServiceWithTransactionalReadOnly;
import com.example.stargram.infrastructure.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ServiceWithTransactionalReadOnly
public class ImageService {

    private final S3Facade s3Facade;
    private final UserFacade userFacade;
    private final ImageRepository imageRepository;

    public ImageUrlResponse execute(List<MultipartFile> images) {
        User user = userFacade.getCurrentUser();

        List<String> imageUrl = images.stream()
                .map(s3Facade::uploadImage)
                .collect(Collectors.toList());

        Image image = Image.builder()
                .user(user)
                .build();
        imageRepository.save(image);

        return new ImageUrlResponse(imageUrl);
    }
}

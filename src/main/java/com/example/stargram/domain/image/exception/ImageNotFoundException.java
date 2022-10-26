package com.example.stargram.domain.image.exception;

import com.example.stargram.global.error.exception.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class ImageNotFoundException extends SnsException {

    public static final ImageNotFoundException EXCEPTION =
            new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ErrorCode.IMAGE_NOT_FOUND);
    }
}

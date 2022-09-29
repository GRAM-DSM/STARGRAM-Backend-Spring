package com.example.stargram.domain.like.exception;

import com.example.stargram.global.error.exception.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class LikeExistsException extends SnsException {

    public static final SnsException EXCEPTION =
            new LikeExistsException();

    private LikeExistsException() {
        super(ErrorCode.LIKE_ALREADY_EXISTS);
    }
}

package com.example.stargram.domain.feedlike.exception;

import com.example.stargram.global.error.exception.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class LikeAlreadyExistsException extends SnsException {

    public static final SnsException EXCEPTION =
            new LikeAlreadyExistsException();

    private LikeAlreadyExistsException() {
        super(ErrorCode.LIKE_ALREADY_EXISTS);
    }

}

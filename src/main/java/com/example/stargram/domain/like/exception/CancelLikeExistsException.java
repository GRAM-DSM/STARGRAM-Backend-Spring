package com.example.stargram.domain.like.exception;

import com.example.stargram.global.error.exception.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class CancelLikeExistsException extends SnsException {

    public static final SnsException EXCEPTION =
            new CancelLikeExistsException();

    private CancelLikeExistsException() {
        super(ErrorCode.LIKE_REMOVE_ALREADY_EXISTS);
    }
}

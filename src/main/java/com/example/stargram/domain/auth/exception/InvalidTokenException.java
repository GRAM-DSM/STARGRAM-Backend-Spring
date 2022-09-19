package com.example.stargram.domain.auth.exception;

import com.example.stargram.global.error.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class InvalidTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}

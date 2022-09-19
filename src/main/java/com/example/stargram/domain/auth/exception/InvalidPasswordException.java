package com.example.stargram.domain.auth.exception;

import com.example.stargram.global.error.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class InvalidPasswordException extends SnsException {
    public static SnsException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}

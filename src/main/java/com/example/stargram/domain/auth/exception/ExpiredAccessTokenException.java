package com.example.stargram.domain.auth.exception;

import com.example.stargram.global.error.exception.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class ExpiredAccessTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new ExpiredAccessTokenException();

    private ExpiredAccessTokenException() {
        super(ErrorCode.EXPIRED_ACCESS_TOKEN);
    }
}

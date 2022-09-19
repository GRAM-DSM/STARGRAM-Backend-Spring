package com.example.stargram.domain.auth.exception;

import com.example.stargram.global.error.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class ExpiredRefreshTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new ExpiredRefreshTokenException();

    private ExpiredRefreshTokenException() {
        super(ErrorCode.EXPIRED_REFRESH_TOKEN);
    }
}

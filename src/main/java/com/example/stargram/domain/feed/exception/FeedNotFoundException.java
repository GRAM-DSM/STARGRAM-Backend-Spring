package com.example.stargram.domain.feed.exception;

import com.example.stargram.global.error.exception.ErrorCode;
import com.example.stargram.global.error.exception.GlobalException;

public class FeedNotFoundException extends GlobalException {

    public static final GlobalException EXCEPTION =
            new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);
    }
}

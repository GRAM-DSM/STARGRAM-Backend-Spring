package com.example.stargram.domain.feed.exception;

import com.example.stargram.global.error.exception.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class FeedNotFoundException extends SnsException {

    public static final SnsException EXCEPTION =
            new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);
    }
}

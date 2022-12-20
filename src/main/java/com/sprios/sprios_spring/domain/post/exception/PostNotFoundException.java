package com.sprios.sprios_spring.domain.post.exception;

import com.sprios.sprios_spring.global.error.ErrorCode;
import com.sprios.sprios_spring.global.error.exception.BusinessException;

public class PostNotFoundException extends BusinessException {
    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}

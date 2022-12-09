package com.sprios.sprios_spring.domain.member.exception;

import com.sprios.sprios_spring.global.error.ErrorCode;
import com.sprios.sprios_spring.global.error.exception.BusinessException;

public class UnAuthorizedAccessException extends BusinessException {
  public UnAuthorizedAccessException() {
    super(ErrorCode.UN_AUTHORIZED_ACCESS);
  }
}

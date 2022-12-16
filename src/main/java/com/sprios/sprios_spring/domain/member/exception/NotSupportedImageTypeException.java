package com.sprios.sprios_spring.domain.member.exception;

import com.sprios.sprios_spring.global.error.exception.BusinessException;

import static com.sprios.sprios_spring.global.error.ErrorCode.FILE_CONVERT_FAIL;

public class NotSupportedImageTypeException extends BusinessException {

  public NotSupportedImageTypeException() {
    super(FILE_CONVERT_FAIL);
  }
}

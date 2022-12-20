package com.sprios.sprios_spring.aws;

import com.sprios.sprios_spring.global.error.ErrorCode;
import com.sprios.sprios_spring.global.error.exception.BusinessException;

public class FileConvertFailException extends BusinessException {

  public FileConvertFailException() {
    super(ErrorCode.FILE_CONVERT_FAIL);
  }
}

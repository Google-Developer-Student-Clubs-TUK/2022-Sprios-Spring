package com.sprios.sprios_spring.domain.member.exception;

import com.sprios.sprios_spring.global.error.ErrorCode;
import com.sprios.sprios_spring.global.error.exception.BusinessException;

public class MemberUpdateFailException extends BusinessException {

  public MemberUpdateFailException() {
    super(ErrorCode.MEMBER_UPDATE_FAIL);
  }
}

package com.sprios.sprios_spring.domain.member.exception;

import com.sprios.sprios_spring.global.error.ErrorCode;
import com.sprios.sprios_spring.global.error.exception.BusinessException;

public class MemberNotFoundException extends BusinessException {
  public MemberNotFoundException() {
    super(ErrorCode.MEMBER_NOT_FOUND);
  }
}

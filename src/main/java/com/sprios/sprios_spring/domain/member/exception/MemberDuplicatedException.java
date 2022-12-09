package com.sprios.sprios_spring.domain.member.exception;

import com.sprios.sprios_spring.global.error.exception.BusinessException;

import static com.sprios.sprios_spring.global.error.ErrorCode.MEMBER_ACCOUNT_DUPLICATED;

public class MemberDuplicatedException extends BusinessException {
  public MemberDuplicatedException() {
    super(MEMBER_ACCOUNT_DUPLICATED);
  }
}

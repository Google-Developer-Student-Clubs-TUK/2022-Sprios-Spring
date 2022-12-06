package com.sprios.sprios_spring.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** {주체}_{이유} message 는 동사 명사형으로 마무리 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
  // Global
  INTERNAL_SERVER_ERROR(500, "G001", "서버 오류"),
  INPUT_INVALID_VALUE(400, "G002", "잘못된 입력"),

  // MemberDomain 도메인
  MEMBER_NOT_FOUND(400, "M001", "회원 찾기 실패"),
  MEMBER_ACCOUNT_DUPLICATED(400, "M002", "회원 아이디 중복")
  ;

  private final int status;
  private final String code;
  private final String message;
}

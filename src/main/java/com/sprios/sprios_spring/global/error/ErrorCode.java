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
  FILE_CONVERT_FAIL(500, "G003", "파일 변환 실패"),

  // MemberDomain 도메인
  MEMBER_NOT_FOUND(400, "U001", "회원 찾기 실패"),
  ;

  private final int status;
  private final String code;
  private final String message;
}

package com.sprios.sprios_spring.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** {행위}_{목적어}_{성공여부} message 는 동사 명사형으로 마무리 */
@Getter
@AllArgsConstructor
public enum ResultCode {

  // 도메인 별로 나눠서 관리
  // Member
  MEMBER_REGISTRATION_SUCCESS("M001", "사용자 등록 성공"),
  MEMBER_ACCOUNT_DUPLICATED("M002", "회원 아이디 중복"),
  MEMBER_ACCOUNT_NOT_DUPLICATED("M003", "회원 아이디 중복되지않음"),
  MEMBER_LOGIN_SUCCESS("M004", "회원 로그인 성공"),
  MEMBER_LOGIN_FAILURE("M005", "회원 로그인 실패"),
  ;

  private final String code;
  private final String message;
}

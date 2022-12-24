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
  MEMBER_LOGOUT_SUCCESS("M005", "회원 로그아웃 성공"),
  MEMBER_UPDATE_SUCCESS("M006", "회원 프로필 업데이트 성공"),

  // Post
  POST_CREATE_SUCCESS("P001", "게시물 생성 성공"),
  POST_GET_SUCCESS("P002", "게시물 조회 성공"),
  WRITER_POST_GET_SUCCESS("P003", "작성자의 게시물들 조회 성공"),
  POST_PAGING_GET_SUCCESS("P004", "게시물들 페이징 조회 성공"),
  ;

  private final String code;
  private final String message;
}

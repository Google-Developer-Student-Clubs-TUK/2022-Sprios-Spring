package com.sprios.sprios_spring.domain.member.dto;

import com.sprios.sprios_spring.domain.member.entity.Gender;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRegistrationRequest {

  private String account;

  @Pattern(
      message = "최소 한개 이상의 대소문자와 숫자, 특수문자를 포함한 8자 이상 16자 이하의 비밀번호를 입력해야 합니다.",
      regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!~$%^&-+=()])(?=\\S+$).{8,16}$")
  private String password;

  private String name;
  private Gender gender;

  @Email(
      message = "유효하지 않은 이메일 형식입니다.",
      regexp =
          "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
  private String email;

  private String phone;
  private String profileImageUrl;
  private String introduce;
}

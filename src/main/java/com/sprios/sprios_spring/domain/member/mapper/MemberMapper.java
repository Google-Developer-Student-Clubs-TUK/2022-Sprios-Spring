package com.sprios.sprios_spring.domain.member.mapper;

import com.sprios.sprios_spring.aws.S3Uploader;
import com.sprios.sprios_spring.domain.member.dto.MemberRegistrationRequest;
import com.sprios.sprios_spring.domain.member.entity.Member;

public class MemberMapper {
  public static Member toEntity(MemberRegistrationRequest memberRegistrationRequest, String imgUrl) {
    return Member.builder()
        .account(memberRegistrationRequest.getAccount())
        .password(memberRegistrationRequest.getPassword())
        .name(memberRegistrationRequest.getName())
        .gender(memberRegistrationRequest.getGender())
        .email(memberRegistrationRequest.getEmail())
        .phone(memberRegistrationRequest.getPhone())
        .profileImageUrl(imgUrl)
        .introduce(memberRegistrationRequest.getIntroduce())
        .build();
  }
}

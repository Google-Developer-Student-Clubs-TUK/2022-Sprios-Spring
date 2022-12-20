package com.sprios.sprios_spring.domain.member.mapper;

import com.sprios.sprios_spring.domain.member.dto.MemberPostInfoResponse;
import com.sprios.sprios_spring.domain.member.dto.MemberRegistrationRequest;
import com.sprios.sprios_spring.domain.member.entity.Member;

public class MemberMapper {
  public static Member toEntity(MemberRegistrationRequest memberRegistrationRequest) {
    return Member.builder()
        .account(memberRegistrationRequest.getAccount())
        .password(memberRegistrationRequest.getPassword())
        .name(memberRegistrationRequest.getName())
        .gender(memberRegistrationRequest.getGender())
        .email(memberRegistrationRequest.getEmail())
        .phone(memberRegistrationRequest.getPhone())
        .introduce(memberRegistrationRequest.getIntroduce())
        .build();
  }

  public static MemberPostInfoResponse toDto(Member member) {
    return MemberPostInfoResponse.builder()
        .id(member.getId())
        .account(member.getAccount())
        .imageUrl(member.getImage().getImgUrl())
        .build();
  }
}

package com.sprios.sprios_spring.domain.member.mapper;

import com.sprios.sprios_spring.domain.member.dto.MemberDto;
import com.sprios.sprios_spring.domain.member.entity.Member;

public class MemberMapper {
    public static Member toEntity(MemberDto memberDto) {
        return Member.builder()
                .account(memberDto.getAccount())
                .password(memberDto.getPassword())
                .name(memberDto.getName())
                .gender(memberDto.getGender())
                .email(memberDto.getEmail())
                .phone(memberDto.getPhone())
                .profileImageUrl(memberDto.getProfileImageUrl())
                .introduce(memberDto.getIntroduce())
                .build();
    }
}

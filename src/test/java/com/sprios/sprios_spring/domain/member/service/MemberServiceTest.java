package com.sprios.sprios_spring.domain.member.service;

import com.sprios.sprios_spring.domain.member.entity.Gender;
import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.member.exception.MemberNotFoundException;
import com.sprios.sprios_spring.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
  @InjectMocks private MemberService memberService;
  @Mock private MemberRepository memberRepository;

  private Member member;

  @BeforeEach
  void init() {
    member =
        Member.builder()
            .account("deca3248")
            .email("deca3248@gmail.com")
            .gender(Gender.MALE)
            .introduce("안녕하세요. 정훈희입니다.")
            .phone("010-1111-1111")
            .name("정훈희")
            .password("my_password")
            .build();
  }

  @Test
  @DisplayName("")
  void canNotFindMemberByAccount() {
    when(memberRepository.findMemberByAccount(any())).thenReturn(Optional.empty());
    assertThrows(
        MemberNotFoundException.class,
        () -> memberService.findMemberByAccount("unknownAccount"));
  }

  @Test
  @DisplayName("")
  void canNotFindMemberById() {
    when(memberRepository.findById(any())).thenReturn(Optional.empty());
    assertThrows(
        MemberNotFoundException.class,
        () -> memberService.findMemberById(Long.MAX_VALUE));
  }
}

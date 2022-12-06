package com.sprios.sprios_spring.domain.member.repository;

import com.sprios.sprios_spring.domain.member.entity.Gender;
import com.sprios.sprios_spring.domain.member.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MemberRepositoryTest {
  @Autowired private MemberRepository memberRepository;

  private Member member =
      Member.builder()
          .account("deca3248")
          .email("deca3248@gmail.com")
          .gender(Gender.MALE)
          .introduce("안녕하세요. 정훈희입니다.")
          .phone("010-1111-1111")
          .name("정훈희")
          .password("my_password")
          .build();

  @BeforeEach
  void setting() {
    memberRepository.save(member);
  }

  @Test
  @DisplayName("ID를 통해서 Member를 찾을 수 있다.")
  void findByIdTest() {
    assertEquals(Optional.of(member), memberRepository.findById(member.getId()));
  }

  @Test
  @DisplayName("Account를 통해서 Member를 찾을 수 있다.")
  void findMemberByAccountTest() {
    assertEquals(Optional.of(member), memberRepository.findMemberByAccount(member.getAccount()));
  }

  @Test
  @DisplayName("Account를 통해서 Member가 존재하는지 알 수 있다.")
  void existsByAccountTest() {
    assertTrue(memberRepository.existsByAccount(member.getAccount()));
    assertFalse(memberRepository.existsByAccount("unknownAccount"));
  }
}

package com.sprios.sprios_spring.domain.member.service;

import com.sprios.sprios_spring.domain.member.dto.LoginRequest;
import com.sprios.sprios_spring.domain.member.dto.MemberDto;
import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.member.exception.MemberNotFoundException;
import com.sprios.sprios_spring.domain.member.repository.MemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberService {
  private final MemberRepository memberRepository;

  // Member 등록
  @Transactional
  public void registrationMember(Member member) {
    memberRepository.save(member);
  }

  public boolean isDuplicatedAccount(String account) {
    return memberRepository.existsByAccount(account);
  }

  public Member findMemberByAccount(String account) {
    return memberRepository.findMemberByAccount(account).orElseThrow(MemberNotFoundException::new);
  }

  public Member findMemberById(long id) {
    return memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
  }

  // 회원 정보가 유효한지 확인
  public boolean isValidMember(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
    Member member = findMemberByAccount(loginRequest.getAccount());
    // DTO로 전달된 비밀번호와 DB에 저장된 암호화된 비밀번호가 같은지 확인
    if (passwordEncoder.matches(loginRequest.getPassword(), member.getPassword())) {
      return true;
    }
    return false;
  }

  //    public boolean isValidPassword(Member member, PasswordRequest passwordRequest,
  // PasswordEncoder passwordEncoder) {
  //
  //        if(passwordEncoder.matches(passwordRequest.getOldPassword(), member.getPassword())) {
  //            return true;
  //        } else {
  //            throw new PasswordNotMatchedException();
  //        }
  //    }

  //  @Transactional
  //  public void updateMemberProfile(Member member, ProfileRequest profileRequest) {
  //    member.updateProfile(profileRequest.getNickname());
  //  }
  //
  //  @Transactional
  //  public void updateMemberPassword(
  //      Member member, PasswordRequest passwordRequest, PasswordEncoder passwordEncoder) {
  //    member.updatePassword(passwordEncoder.encode(passwordRequest.getNewPassword()));
  //  }
}

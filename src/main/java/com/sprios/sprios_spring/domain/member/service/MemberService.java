package com.sprios.sprios_spring.domain.member.service;

import com.sprios.sprios_spring.domain.member.dto.LoginRequest;
import com.sprios.sprios_spring.domain.member.dto.MemberRegistrationRequest;
import com.sprios.sprios_spring.domain.member.mapper.MemberMapper;
import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.member.exception.MemberNotFoundException;
import com.sprios.sprios_spring.domain.member.repository.MemberRepository;
import com.sprios.sprios_spring.global.util.PasswordUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberService {
  private final MemberRepository memberRepository;
  private final PasswordUtil passwordUtil;

  public void registrationMember(MemberRegistrationRequest memberRegistrationRequest) {
    Member member = MemberMapper.toEntity(memberRegistrationRequest);
    member.setEncryptedPassword(passwordUtil.encodingPassword(member.getPassword()));
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

  public boolean isValidMember(LoginRequest loginRequest) {
    Member member = findMemberByAccount(loginRequest.getAccount());
    if (passwordUtil.isSamePassword(loginRequest.getPassword(), member.getPassword())) {
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

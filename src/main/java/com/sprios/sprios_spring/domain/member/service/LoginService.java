package com.sprios.sprios_spring.domain.member.service;

import com.sprios.sprios_spring.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginService {
  private final HttpSession httpSession;
  private final MemberService memberService;
  private static final String MEMBER_ID = "MEMBER_ID";

  public void login(long id) {
    httpSession.setAttribute(MEMBER_ID, id);
  }

  public void logout() {
    httpSession.removeAttribute(MEMBER_ID);
  }

  public Member getLoginMember() {
    Long memberId = (Long) httpSession.getAttribute(MEMBER_ID);
    return memberService.findMemberById(memberId);
  }

  public Long getLoginMemberId() {
    return (Long) httpSession.getAttribute(MEMBER_ID);
  }
}

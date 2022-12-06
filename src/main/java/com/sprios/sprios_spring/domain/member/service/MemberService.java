package com.sprios.sprios_spring.domain.member.service;

import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.member.exception.MemberNotFoundException;
import com.sprios.sprios_spring.domain.member.repository.MemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
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
}

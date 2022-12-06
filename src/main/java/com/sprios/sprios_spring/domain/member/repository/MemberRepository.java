package com.sprios.sprios_spring.domain.member.repository;

import com.sprios.sprios_spring.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
  boolean existsByAccount(String account);

  Optional<Member> findMemberByAccount(String account);
}

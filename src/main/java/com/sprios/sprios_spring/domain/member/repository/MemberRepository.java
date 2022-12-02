package com.sprios.sprios_spring.domain.member.repository;

import com.sprios.sprios_spring.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

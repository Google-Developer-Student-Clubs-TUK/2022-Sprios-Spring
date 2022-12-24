package com.sprios.sprios_spring.domain.member.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberUpdateProfileRequest {
  private String name;
  private String account;
  private String introduce;
}

package com.sprios.sprios_spring.domain.member.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberPostInfoResponse {
    private Long id;
    private String account;
    private String imageUrl;
}

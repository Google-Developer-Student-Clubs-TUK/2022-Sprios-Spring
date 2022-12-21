package com.sprios.sprios_spring.domain.post.dto;

import com.sprios.sprios_spring.domain.member.dto.MemberPostInfoResponse;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostInfoResponse {
    private String content;
    private MemberPostInfoResponse memberPostInfoResponse;
    private List<String> imageUrls;
    private Integer likeCount;
    private LocalDateTime createdAt;
}

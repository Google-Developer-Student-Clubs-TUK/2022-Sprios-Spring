package com.sprios.sprios_spring.domain.post.dto;

import lombok.*;

import javax.validation.constraints.Pattern;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostCreateRequest {
  @Pattern(message = "게시물의 내용은 최소 1자이상, 300자 이하여야 합니다.", regexp = "^.{1,300}$")
  private String content;
}

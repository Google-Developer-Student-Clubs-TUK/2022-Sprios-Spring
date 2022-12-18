package com.sprios.sprios_spring.domain.post.mapper;

import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.post.dto.PostCreateRequest;
import com.sprios.sprios_spring.domain.post.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
  public Post toEntity(PostCreateRequest postCreateRequest, Member loginMember) {
    return Post.builder().content(postCreateRequest.getContent()).writer(loginMember).build();
  }
}

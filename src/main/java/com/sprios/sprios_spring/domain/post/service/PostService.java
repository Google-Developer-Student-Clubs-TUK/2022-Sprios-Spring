package com.sprios.sprios_spring.domain.post.service;

import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.post.dto.PostCreateRequest;
import com.sprios.sprios_spring.domain.post.entity.Post;
import com.sprios.sprios_spring.domain.post.mapper.PostMapper;
import com.sprios.sprios_spring.domain.post.repository.PostRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PostService {
  private final PostRepository postRepository;
  private final PostMapper postMapper;

  public void createPost(PostCreateRequest postCreateRequest, Member loginMember) {
    Post post = postMapper.toEntity(postCreateRequest, loginMember);
    postRepository.save(post);
  }
}

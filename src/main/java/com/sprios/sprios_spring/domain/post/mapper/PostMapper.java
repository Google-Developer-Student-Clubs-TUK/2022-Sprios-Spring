package com.sprios.sprios_spring.domain.post.mapper;

import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.member.mapper.MemberMapper;
import com.sprios.sprios_spring.domain.post.dto.PostCreateRequest;
import com.sprios.sprios_spring.domain.post.dto.PostInfoResponse;
import com.sprios.sprios_spring.domain.post.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {
  public Post toEntity(PostCreateRequest postCreateRequest, Member loginMember) {
    return Post.builder().content(postCreateRequest.getContent()).writer(loginMember).build();
  }

  public PostInfoResponse toDto(Post post) {
    return PostInfoResponse.builder()
        .content(post.getContent())
        .createdAt(post.getCreatedAt())
        .likeCount(post.getLikeCount())
        .memberPostInfoResponse(MemberMapper.toDto(post.getWriter()))
        .imageUrls(post.getImageUrlList())
        .build();
  }

  public List<PostInfoResponse> toDtoList(List<Post> posts) {
    return posts.stream().map(this::toDto).collect(Collectors.toList());
  }
}

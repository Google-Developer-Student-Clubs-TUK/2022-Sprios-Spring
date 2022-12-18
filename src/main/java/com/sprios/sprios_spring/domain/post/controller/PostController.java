package com.sprios.sprios_spring.domain.post.controller;

import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.post.dto.PostCreateRequest;
import com.sprios.sprios_spring.domain.post.service.PostService;
import com.sprios.sprios_spring.global.annotation.LoginMember;
import com.sprios.sprios_spring.global.annotation.LoginRequired;
import com.sprios.sprios_spring.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import javax.validation.Valid;

import static com.sprios.sprios_spring.global.result.ResultCode.POST_CREATE_SUCCESS;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/api/posts")
public class PostController {
  private final PostService postService;

  @LoginRequired
  @PostMapping
  public ResponseEntity<ResultResponse> createPost(
      @LoginMember @ApiIgnore Member loginMember,
      @RequestBody @Valid PostCreateRequest postCreateRequest) {
    postService.createPost(postCreateRequest, loginMember);
    return ResponseEntity.ok(ResultResponse.of(POST_CREATE_SUCCESS));
  }
}

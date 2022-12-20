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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;
import javax.validation.Valid;

import java.util.List;

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
      @RequestPart(value = "images", required = false) List<MultipartFile> images,
      @RequestPart(value = "postCreateRequest") @Valid PostCreateRequest postCreateRequest) {
    postService.createPost(postCreateRequest, loginMember, images);
    return ResponseEntity.ok(ResultResponse.of(POST_CREATE_SUCCESS));
  }
}
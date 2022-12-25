package com.sprios.sprios_spring.domain.post.controller;

import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.post.dto.PostCreateRequest;
import com.sprios.sprios_spring.domain.post.dto.PostInfoResponse;
import com.sprios.sprios_spring.domain.post.service.PostService;
import com.sprios.sprios_spring.global.annotation.LoginMember;
import com.sprios.sprios_spring.global.annotation.LoginRequired;
import com.sprios.sprios_spring.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;
import javax.validation.Valid;

import java.util.List;

import static com.sprios.sprios_spring.global.result.ResultCode.*;

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
      @RequestPart(value = "content") String content) {
    postService.createPost(content, loginMember, images);
    return ResponseEntity.ok(ResultResponse.of(POST_CREATE_SUCCESS));
  }

  @GetMapping("/{postId}")
  public ResponseEntity<ResultResponse> getPost(@PathVariable Long postId) {
    PostInfoResponse postInfoResponse = postService.getPostById(postId);
    return ResponseEntity.ok(ResultResponse.of(POST_GET_SUCCESS, postInfoResponse));
  }

  @GetMapping("/writer")
  public ResponseEntity<ResultResponse> getMemberPostList(@RequestParam Long id) {
    List<PostInfoResponse> postInfoResponseList = postService.getPostListByWriterId(id);
    return ResponseEntity.ok(ResultResponse.of(WRITER_POST_GET_SUCCESS, postInfoResponseList));
  }

  @GetMapping("/page/{page}")
  public ResponseEntity<ResultResponse> getPostListWithPaging(
      @PathVariable Integer page, @RequestParam(defaultValue = "10") Integer size) {
    PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
    Page<PostInfoResponse> postInfoResponseList = postService.getPostListWithPaging(pageRequest);
    return ResponseEntity.ok(
        ResultResponse.of(POST_PAGING_GET_SUCCESS, postInfoResponseList.getContent()));
  }
}

package com.sprios.sprios_spring.domain.member.controller;

import com.sprios.sprios_spring.domain.member.service.LoginService;
import com.sprios.sprios_spring.domain.member.service.MemberService;
import com.sprios.sprios_spring.global.result.ResultCode;
import com.sprios.sprios_spring.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.sprios.sprios_spring.domain.member.controller.MemberUpdateController.MEMBER_API_URI;

@RestController
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping(MEMBER_API_URI)
public class MemberUpdateController {
  public static final String MEMBER_API_URI = "/api/update";
  private final LoginService loginService;

  @PostMapping("/img")
  public ResponseEntity<ResultResponse> uploadImage(@RequestParam MultipartFile uploadImage) {
    loginService.uploadImgS3(uploadImage);
    return ResponseEntity.ok(ResultResponse.of(ResultCode.MEMBER_IMAGEUPDATE_SUCCESS, true));
  }
}
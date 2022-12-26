package com.sprios.sprios_spring.domain.member.controller;

import com.sprios.sprios_spring.domain.member.dto.MemberUpdateProfileRequest;
import com.sprios.sprios_spring.domain.member.service.MemberUpdateService;
import com.sprios.sprios_spring.global.annotation.LoginRequired;
import com.sprios.sprios_spring.global.result.ResultCode;
import com.sprios.sprios_spring.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.sprios.sprios_spring.domain.member.controller.MemberUpdateController.MEMBER_API_URI;

@RestController
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping(MEMBER_API_URI)
public class MemberUpdateController {
  public static final String MEMBER_API_URI = "/api/members";
  private final MemberUpdateService memberUpdateService;

  @LoginRequired
  @PostMapping("/update")
  public ResponseEntity<ResultResponse> updateMember(
      @RequestPart (value = "image", required = false) MultipartFile uploadImage,
      @RequestPart String name,
      @RequestPart String account,
      @RequestPart String introduce) {
    MemberUpdateProfileRequest memberUpdateProfileRequest = MemberUpdateProfileRequest
        .builder().name(name).account(account).introduce(introduce).build();
    memberUpdateService.updateMemberProfile(uploadImage, memberUpdateProfileRequest);
    return ResponseEntity.ok(ResultResponse.of(ResultCode.MEMBER_UPDATE_SUCCESS, true));
  }
}

package com.sprios.sprios_spring.domain.member.controller;

import com.sprios.sprios_spring.domain.member.dto.LoginRequest;
import com.sprios.sprios_spring.domain.member.dto.MemberDto;
import com.sprios.sprios_spring.domain.member.exception.MemberDuplicatedException;
import com.sprios.sprios_spring.domain.member.exception.MemberNotFoundException;
import com.sprios.sprios_spring.domain.member.service.MemberService;
import com.sprios.sprios_spring.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.sprios.sprios_spring.domain.member.controller.MemberController.MEMBER_API_URI;
import static com.sprios.sprios_spring.global.result.ResultCode.*;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@RequestMapping(MEMBER_API_URI)
public class MemberController {

  public static final String MEMBER_API_URI = "/api/members";

  private final MemberService memberService;
  private final PasswordEncoder passwordEncoder;

  @PostMapping
  public ResponseEntity<ResultResponse> registration(@RequestBody @Valid MemberDto memberDto) {
    if (memberService.isDuplicatedAccount(memberDto.getAccount())) {
      throw new MemberDuplicatedException();
    }
    memberService.registrationMember(memberDto);
    return ResponseEntity.ok(ResultResponse.of(MEMBER_REGISTRATION_SUCCESS));
  }

  @GetMapping("/duplicated/{account}")
  public ResponseEntity<ResultResponse> isDuplicatedAccount(@PathVariable String account) {
    boolean isDuplicated = memberService.isDuplicatedAccount(account);

    if (isDuplicated) {
      return ResponseEntity.ok(ResultResponse.of(MEMBER_ACCOUNT_DUPLICATED, true));
    }
    return ResponseEntity.ok(ResultResponse.of(MEMBER_ACCOUNT_NOT_DUPLICATED, false));
  }

  @PostMapping("/login")
  public ResponseEntity<ResultResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
    boolean isValidMember = memberService.isValidMember(loginRequest, passwordEncoder);

    if (isValidMember) {
      return ResponseEntity.ok(ResultResponse.of(MEMBER_LOGIN_SUCCESS));
    }
    throw new MemberNotFoundException();
  }
}

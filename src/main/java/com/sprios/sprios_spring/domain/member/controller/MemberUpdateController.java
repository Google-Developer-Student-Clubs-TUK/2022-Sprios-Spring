package com.sprios.sprios_spring.domain.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sprios.sprios_spring.domain.member.controller.MemberUpdateController.MEMBER_API_URI;

@RestController
@Slf4j
@RequestMapping(MEMBER_API_URI)
public class MemberUpdateController {
  public static final String MEMBER_API_URI = "/api/update";
}

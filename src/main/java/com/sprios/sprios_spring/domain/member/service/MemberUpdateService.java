package com.sprios.sprios_spring.domain.member.service;


import com.sprios.sprios_spring.aws.S3Uploader;
import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.member.repository.MemberRepository;
import com.sprios.sprios_spring.global.util.ImageUtil;
import com.sprios.sprios_spring.global.vo.Image;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberUpdateService {
  private static final String MEMBER_S3_DIRNAME = "member";
  private final HttpSession httpSession;
  private final MemberService memberService;
  private final S3Uploader s3Uploader;
  private final MemberRepository memberRepository;
  private static final String MEMBER_ID = "MEMBER_ID";

  @Transactional
  public void uploadImgS3(MultipartFile file) {
    final Member member = getLoginMember();
    final Image oldImage = member.getImage();
    s3Uploader.deleteImage(oldImage.getImgName(), MEMBER_S3_DIRNAME);
    String imgUrl = s3Uploader.uploadImage(file, MEMBER_S3_DIRNAME);
    Image newImage = ImageUtil.convertMultipartFiletoImage(file, imgUrl);
    member.setImage(newImage);
    memberRepository.save(member);
  }
  private Member getLoginMember() {
    Long memberId = (Long) httpSession.getAttribute(MEMBER_ID);
    return memberService.findMemberById(memberId);
  }
}

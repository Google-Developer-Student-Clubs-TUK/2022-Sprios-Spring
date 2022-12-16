package com.sprios.sprios_spring.domain.member.entity;

import com.sprios.sprios_spring.global.entity.BaseEntity;
import com.sprios.sprios_spring.global.vo.Image;
import com.sprios.sprios_spring.global.vo.ImageType;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class Member extends BaseEntity {
  private static final String DEFAULT_IMAGE_URL =
      "https://identitylessimgserver.s3.ap-northeast-2.amazonaws.com/member/base_profile.png";
  private static final String IMAGE_URL_COLUMN_DEFINITION =
      "varchar(500) default \'" + DEFAULT_IMAGE_URL + "\'";

  @Id
  @Column(name = "member_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "member_account", unique = true, nullable = false)
  private String account;

  @Column(name = "user_password", nullable = false)
  private String password;

  @Column(name = "user_name", nullable = false)
  private String name;

  @Column(name = "user_gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(name = "user_email")
  private String email;

  @Column(name = "user_phone")
  private String phone;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "imgUrl", column = @Column(name = "member_image_url")),
      @AttributeOverride(name = "imgType", column = @Column(name = "member_image_type")),
      @AttributeOverride(name = "imgName", column = @Column(name = "member_image_name")),
      @AttributeOverride(name = "imgUUID", column = @Column(name = "member_image_uuid"))
  })
  private Image image;

  @Column(name = "user_introduce")
  private String introduce;

  @Builder
  private Member(
      String account,
      String password,
      String name,
      Gender gender,
      String phone,
      String email,
      String introduce) {
    this.account = account;
    this.password = password;
    this.name = name;
    this.gender = gender;
    this.phone = phone;
    this.email = email;
    this.image = Image.builder()
        .imgName("base_profile")
        .imgType(ImageType.PNG)
        .imgUrl(DEFAULT_IMAGE_URL)
        .imgUUID("base-UUID").build();
    this.introduce = "";
  }

  public void setEncryptedPassword(String encryptedPassword) {
    this.password = encryptedPassword;
  }
}

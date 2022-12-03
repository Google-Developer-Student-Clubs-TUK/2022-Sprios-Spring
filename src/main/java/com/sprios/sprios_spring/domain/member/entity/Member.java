package com.sprios.sprios_spring.domain.member.entity;

import com.sprios.sprios_spring.global.entity.BaseEntity;
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
      "https://bluetifulc-spring-bucket.s3.ap-northeast-2.amazonaws.com/member/base-UUID_base.PNG";
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

  @Column(name = "user_profile_image_url", columnDefinition = IMAGE_URL_COLUMN_DEFINITION)
  private String profileImageUrl;

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
    this.introduce = introduce;
  }
}

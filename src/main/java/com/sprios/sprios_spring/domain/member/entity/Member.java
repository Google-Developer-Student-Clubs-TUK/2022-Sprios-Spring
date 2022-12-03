package com.sprios.sprios_spring.domain.member.entity;

import com.sprios.sprios_spring.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "members")
public class Member extends BaseEntity {
  final private String DEFAULT_IMAGE_URL = "https://bluetifulc-spring-bucket.s3.ap-northeast-2.amazonaws.com/member/base-UUID_base.PNG";
  @Id
  @Column(name = "member_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  @Column(name = "user_profile_image_url")
  private String profileImageUrl;
  @Column(name = "user_introduce")
  private String introduce;

  public Member(String account, String password, String name, Gender gender,
                String phone, String email, String introduce) {
    this.account = account;
    this.password = password;
    this.name = name;
    this.gender = gender;
    this.phone = phone;
    this.email = email;
    this.profileImageUrl = DEFAULT_IMAGE_URL;
    this.introduce = introduce;
  }

  public void updateName(String name) {
    this.name = name;
  }

  public void updateGender(Gender gender) {
    this.gender = gender;
  }

  public void updatePhone(String phone) {
    this.phone = phone;
  }

  public void updateEmail(String email) {
    this.email = email;
  }

  public void updateProfileImageUrl(String url) {
    this.profileImageUrl = url;
  }

  public void updateIntroduce(String introduce) {
    this.introduce = introduce;
  }

  /* 암호화된 패스워드 */
  public void setEncryptedPassword(String encryptedPassword) {
    this.password = encryptedPassword;
  }

  public void deleteImage() {
    this.profileImageUrl = DEFAULT_IMAGE_URL;
  }
}

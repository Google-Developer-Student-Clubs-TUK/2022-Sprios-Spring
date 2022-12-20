package com.sprios.sprios_spring.domain.post.entity;

import com.sprios.sprios_spring.global.vo.Image;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostImage {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private Integer imageNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private Post post;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "imgUrl", column = @Column(name = "member_image_url")),
    @AttributeOverride(name = "imgType", column = @Column(name = "member_image_type")),
    @AttributeOverride(name = "imgName", column = @Column(name = "member_image_name")),
    @AttributeOverride(name = "imgUUID", column = @Column(name = "member_image_uuid"))
  })
  private Image image;

  @Builder
  private PostImage(Integer imageNumber, Post post, Image image) {
    this.imageNumber = imageNumber;
    this.post = post;
    this.image = image;
  }
}

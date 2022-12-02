package com.sprios.sprios_spring.domain.post.entity;

import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.global.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@ToString(callSuper = true)
public class Post extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "post_id")
  private Long id;

  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member writer;

  @Builder
  private Post(String content, Member writer) {
    this.content = content;
    this.writer = writer;
  }
}

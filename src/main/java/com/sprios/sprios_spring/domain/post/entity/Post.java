package com.sprios.sprios_spring.domain.post.entity;

import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.global.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class Post extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "post_id")
  private Long id;

  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "writer_id")
  private Member writer;

  @OneToMany private List<PostLike> postLikeList = new ArrayList<>();

  @Builder
  private Post(String content, Member writer) {
    this.content = content;
    this.writer = writer;
  }

  public int getLikeCount() {
    return this.postLikeList.size();
  }
}

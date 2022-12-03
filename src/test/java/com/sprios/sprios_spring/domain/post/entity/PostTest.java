package com.sprios.sprios_spring.domain.post.entity;

import com.sprios.sprios_spring.domain.member.entity.Gender;
import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.member.repository.MemberRepository;
import com.sprios.sprios_spring.domain.post.repository.PostLikeRepository;
import com.sprios.sprios_spring.domain.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostTest {
  @Autowired private PostRepository postRepositoey;
  @Autowired private MemberRepository memberRepository;
  @Autowired private PostLikeRepository postLikeRepository;

  @Test
  void PostLikeTest() {
    // given
    Member member1 = Member.builder().account("abcd").password("password").name("김우중").gender(Gender.MALE).build();
    Member member2 = Member.builder().account("abcde").password("password").name("정훈희").gender(Gender.MALE).build();
    Member member3 = Member.builder().account("abcdef").password("password").name("오연서").gender(Gender.FEMALE).build();
    Post post1 = Post.builder().content("post1").writer(member1).build();
    Post post2 = Post.builder().content("post2").writer(member2).build();
    memberRepository.saveAll(List.of(member1, member2, member3));
    postRepositoey.saveAll(List.of(post1, post2));

    // when
    PostLike postLike1 = PostLike.builder().member(member2).post(post1).build();
    PostLike postLike2 = PostLike.builder().member(member3).post(post1).build();
    PostLike postLike3 = PostLike.builder().member(member1).post(post2).build();
    postLikeRepository.saveAll(List.of(postLike1, postLike2, postLike3));

    // then
    assertEquals(2, postLikeRepository.countPostLikeByPostId(post1.getId()));
    assertEquals(1, postLikeRepository.countPostLikeByPostId(post2.getId()));
  }
}

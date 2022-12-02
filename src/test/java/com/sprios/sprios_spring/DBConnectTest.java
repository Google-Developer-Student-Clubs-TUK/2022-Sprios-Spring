package com.sprios.sprios_spring;

import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.member.repository.MemberRepository;
import com.sprios.sprios_spring.domain.post.entity.Post;
import com.sprios.sprios_spring.domain.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBConnectTest {
  @Autowired PostRepository postRepositoey;
  @Autowired MemberRepository memberRepository;

  @Test
  void EntitySaveTest() {
    Member member = new Member();
    memberRepository.save(member);
    Post post = Post.builder().writer(member).content("hello world").build();
    postRepositoey.save(post);
    assertEquals(
        post.getContent(),
        postRepositoey.findById(post.getId()).get().getContent(),
        "게시물의 내용이 같다.");
    assertEquals(
        member.getId(),
        postRepositoey.findById(post.getId()).get().getWriter().getId(),
        "작성자의 ID가 같다.");
  }
}

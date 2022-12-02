package com.sprios.sprios_spring.domain.post.repository;

import com.sprios.sprios_spring.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {}

package com.sprios.sprios_spring.domain.post.repository;

import com.sprios.sprios_spring.domain.post.entity.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<List<Post>> findAllByWriterId(Long writerId, Sort sort);
}

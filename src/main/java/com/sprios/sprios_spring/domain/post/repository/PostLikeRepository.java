package com.sprios.sprios_spring.domain.post.repository;

import com.sprios.sprios_spring.domain.post.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    int countPostLikeByPostId(Long postId);
}

package com.sprios.sprios_spring.domain.post.service;

import com.sprios.sprios_spring.aws.S3Uploader;
import com.sprios.sprios_spring.domain.member.entity.Member;
import com.sprios.sprios_spring.domain.member.exception.MemberNotFoundException;
import com.sprios.sprios_spring.domain.post.dto.PostCreateRequest;
import com.sprios.sprios_spring.domain.post.dto.PostInfoResponse;
import com.sprios.sprios_spring.domain.post.entity.Post;
import com.sprios.sprios_spring.domain.post.entity.PostImage;
import com.sprios.sprios_spring.domain.post.exception.PostNotFoundException;
import com.sprios.sprios_spring.domain.post.mapper.PostMapper;
import com.sprios.sprios_spring.domain.post.repository.PostImageRepository;
import com.sprios.sprios_spring.domain.post.repository.PostRepository;
import com.sprios.sprios_spring.global.util.ImageUtil;
import com.sprios.sprios_spring.global.vo.Image;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PostService {
  private static final String POST_S3_DIRNAME = "post";
  private final PostRepository postRepository;
  private final PostImageRepository postImageRepository;
  private final PostMapper postMapper;
  private final S3Uploader s3Uploader;

  @Transactional
  public void createPost(
      String content, Member loginMember, List<MultipartFile> imageFiles) {
    Post post = postMapper.toEntity(content, loginMember);
    postRepository.save(post);
    for (int i = 0; i < imageFiles.size(); i++) {
      MultipartFile imageFile = imageFiles.get(i);
      String imgUrl = s3Uploader.uploadImage(imageFile, POST_S3_DIRNAME);
      Image newImage = ImageUtil.convertMultipartFiletoImage(imageFile, imgUrl);
      postImageRepository.save(
          PostImage.builder().image(newImage).imageNumber(i).post(post).build());
    }
  }

  public List<PostInfoResponse> getPostListByWriterId(Long writerId) {
    List<Post> posts =
        postRepository
            .findAllByWriterId(writerId, Sort.by("id").descending())
            .orElseThrow(MemberNotFoundException::new);
    return postMapper.toDtoList(posts);
  }

  public PostInfoResponse getPostById(Long postId) {
    Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
    return postMapper.toDto(post);
  }

  public Page<PostInfoResponse> getPostListWithPaging(PageRequest pageRequest) {
    Page<Post> postPages = postRepository.findAll(pageRequest);
    return postMapper.toDtoList(postPages);
  }
}

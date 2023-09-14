package com.jpa.task.repository.post;

import com.jpa.task.domain.PostDTO;
import com.jpa.task.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostQueryDSL {
//    게시글 목록(댓글 개수 포함)
    public List<PostDTO> findAllWithReplyCount();

//    게시글 조회
    public Optional<Post> findPostById(Long id);
}

package com.jpa.task.service;

import com.jpa.task.domain.PostDTO;
import com.jpa.task.repository.post.PostRepository;
import com.jpa.task.repository.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;

    @Override
    public List<PostDTO> getList() {
        return postRepository.findAllWithReplyCount();
    }

    @Override
    public PostDTO getPost(Long id) {
        final PostDTO postDTO = toDTO(postRepository.findPostById(id).orElseThrow(() -> {
            throw new RuntimeException();
        }));
        postDTO.setReplyCount(replyRepository.findAll_QueryDSL(id).size());
        return postDTO;
    }
}

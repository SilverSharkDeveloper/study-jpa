package com.jpa.task.repository.post;

import com.jpa.task.domain.PostDTO;
import com.jpa.task.entity.Post;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.jpa.task.entity.QPost.post;
import static com.jpa.task.entity.QReply.reply;

@RequiredArgsConstructor
public class PostQueryDSLImpl implements PostQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public List<PostDTO> findAllWithReplyCount() {
//        select절에서 서브쿼리(JPAExpressions)를 사용한다면, Projections를 사용해야 한다.
//        Projections.fields() : 필드명 매핑
//        Projections.constructor() : 생성자 사용
        return  query.select(
                Projections.fields(
                        PostDTO.class,
                        post.id,
                        post.postTitle,
                        post.postContent,
                        ExpressionUtils.as(
                            (JPAExpressions
                                    .select(reply.id.count().intValue())
                                    .from(reply)
                                    .where(reply.post.id.eq(post.id).and(reply.depth.eq(1L))))
                        , "replyCount")
                )
        ).from(post).fetch();
    }

    @Override
    public Optional<Post> findPostById(Long id) {
        return Optional.ofNullable(query.selectFrom(post).where(post.id.eq(id)).fetchOne());
    }
}










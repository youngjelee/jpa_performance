package com.allmytour.ai.app.mock.repository.custom;

import com.allmytour.ai.app.mock.dto.PostResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.allmytour.ai.app.mock.entity.QCategory.*;
import static com.allmytour.ai.app.mock.entity.QPost.*;
import static com.allmytour.ai.app.mock.entity.QUser.*;

@RequiredArgsConstructor
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PostResponseDto> getListPostResponseDto(Long userId , Pageable pageable) {

        List<PostResponseDto> list =
        jpaQueryFactory.select(
                Projections.constructor(
                        PostResponseDto.class
                        ,post.id
                        ,post.title
                        ,post.content
                        ,user.id
                        ,user.username
                        ,user.email
                        ,category.id
                        ,category.name
                )
        ).from(post)
                .join(post.user , user ) // .fetchJoin()
                .leftJoin(post.category , category) // .fetchJoin()
                .where(
                        post.user.id.eq(userId)
                        , category.id.isNotNull()

                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
//                .order
                .fetch()
        ;

//        List<Post> list =
//        jpaQueryFactory.select(
//                post
//        ).from(post)
//                .join(post.user , user ).fetchJoin()
//                .leftJoin(post.category , category).fetchJoin()
//                .where( post.user.id.eq(userId))
//                .fetch()
//        ;



        return list;
    }

    @Override
    public Long getListPostResponseDtoLongCount(Long userId, Pageable pageable) {
        return jpaQueryFactory.select(
                post.count()
        ).from(post)
                .join(post.user , user ) // .fetchJoin()
                .leftJoin(post.category , category) // .fetchJoin()
                .where(
                        post.user.id.eq(userId)
                        , category.id.isNotNull()

                ).fetchOne();

    }
}

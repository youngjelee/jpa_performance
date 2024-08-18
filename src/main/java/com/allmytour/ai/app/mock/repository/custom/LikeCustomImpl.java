package com.allmytour.ai.app.mock.repository.custom;

import com.allmytour.ai.app.mock.entity.*;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.allmytour.ai.app.mock.entity.QComment.*;
import static com.allmytour.ai.app.mock.entity.QLike.*;
import static com.allmytour.ai.app.mock.entity.QPost.*;
import static com.allmytour.ai.app.mock.entity.QUser.*;

@RequiredArgsConstructor
public class LikeCustomImpl implements LikeCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Like getLikeJoinData() {

        List<Like> likeList =
        jpaQueryFactory
                .select(like )
                .from(like)
                .leftJoin(like.user , user).fetchJoin()
                .leftJoin(like.post  , post).fetchJoin()
                .fetch();

        System.out.println("===========");

        return null;
    }
}

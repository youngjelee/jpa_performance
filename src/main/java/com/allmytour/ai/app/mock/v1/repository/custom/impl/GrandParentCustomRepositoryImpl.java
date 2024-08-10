package com.allmytour.ai.app.mock.v1.repository.custom.impl;

import com.allmytour.ai.app.mock.v1.domain.GrandParent;
import com.allmytour.ai.app.mock.v1.domain.QParent;
import com.allmytour.ai.app.mock.v1.repository.custom.GrandParentCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.allmytour.ai.app.mock.v1.domain.QGrandParent.grandParent;

@RequiredArgsConstructor
public class GrandParentCustomRepositoryImpl implements GrandParentCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public GrandParent getRandomGrandParent() {
        return jpaQueryFactory
                .selectFrom(grandParent)
                .fetchFirst();

    }

    @Override
    public GrandParent getGrandParent(Long id ) {

        // fetcjoin 은 1:N 구조 여러개 불가 . 하나씩밖에안됨
        GrandParent _grandParent =
        jpaQueryFactory
                .select(grandParent)
                .from(grandParent)
                .leftJoin(grandParent.parents , QParent.parent ).fetchJoin()
//                .leftJoin( QParent.parent.childs , QChild.child ).fetchJoin()
                .where(grandParent.id.eq( id ) )
                .fetchOne();





        System.out.println(_grandParent);

        return null;
    }
}

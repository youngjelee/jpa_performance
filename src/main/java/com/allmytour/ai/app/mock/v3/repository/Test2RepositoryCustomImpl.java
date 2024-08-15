package com.allmytour.ai.app.mock.v3.repository;

import com.allmytour.ai.app.mock.v3.entity.QTest1;
import com.allmytour.ai.app.mock.v3.entity.QTest2;
import com.allmytour.ai.app.mock.v3.entity.Test2;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.allmytour.ai.app.mock.v3.entity.QTest1.*;
import static com.allmytour.ai.app.mock.v3.entity.QTest2.*;

@RequiredArgsConstructor
public class Test2RepositoryCustomImpl implements Test2RepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Test2> getData(String name) {

        List<Test2> list =
         jpaQueryFactory
                .select(test2)
                .from( test2)
                .join( test2.test1 , test1)
                .where( test2.name.eq("test__1"))
                .fetch();

         return list;

    }

    @Override
    public List<Test2> getFetchJoinData(String name) {
        List<Test2> list =
                jpaQueryFactory
                        .select(test2)
                        .from( test2)
                        .join( test2.test1 , test1).fetchJoin()
                        .where( test2.name.eq("test__1"))
                        .fetch();

        return list;
    }

    @Override
    public List<Test2> getFetchJoinDataFilterTest1(String name , Long id ) {
        List<Test2> list =
                jpaQueryFactory
                        .select(test2)
                        .from( test2)
                        .join( test2.test1 , test1).fetchJoin()
                        .where(
                                test1.id.loe( id)
                        )
                        .fetch();

        return list;
    }
}

package com.allmytour.ai.app.mock.v3.repository;

import com.allmytour.ai.app.mock.v3.entity.JoinData;
import com.allmytour.ai.app.mock.v3.entity.QNoForienTest;
import com.allmytour.ai.app.mock.v3.entity.QTest1;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Projection;

import java.util.List;

import static com.allmytour.ai.app.mock.v3.entity.QNoForienTest.noForienTest;
import static com.allmytour.ai.app.mock.v3.entity.QTest1.test1;

@RequiredArgsConstructor

public class NoForCustomImpl implements NoForCustom{

    private final JPAQueryFactory factory;


    @Override
    public List<JoinData> getJoinData(Long limit , String name ) {

        return
        factory.select(
                        Projections.constructor(
                                JoinData.class,
                                test1,
                                noForienTest
                        )
                )
                .from(test1)
                .join(noForienTest)
                    .on( test1.id .eq(  noForienTest.test1id )  )
                 .where(noForienTest.name.like("%" + name + "%"))
//                .limit(100)
                .fetch();


    }
}

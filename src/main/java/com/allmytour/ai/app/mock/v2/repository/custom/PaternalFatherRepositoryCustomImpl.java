package com.allmytour.ai.app.mock.v2.repository.custom;

import com.allmytour.ai.app.mock.v2.dto.res.PaternalGrandFatherResponse;
import com.allmytour.ai.app.mock.v2.entity.*;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.allmytour.ai.app.mock.v2.entity.QBaby.baby;
import static com.allmytour.ai.app.mock.v2.entity.QFather.father;
import static com.allmytour.ai.app.mock.v2.entity.QPaternalGrandFather.paternalGrandFather;

@RequiredArgsConstructor
public class PaternalFatherRepositoryCustomImpl implements PaternalFatherRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public PaternalGrandFatherResponse getPaternalGrandFatherById(Long id) {

        PaternalGrandFather resultList =
            jpaQueryFactory
                    .select(
                            paternalGrandFather
                    )
                    .from( paternalGrandFather)
                    .leftJoin( paternalGrandFather.fathers , father)
                    .leftJoin ( father.babyList , baby)
                    .where(
                            paternalGrandFather.id.eq( id )
                    )
                    .fetchOne();

        PaternalGrandFatherResponse p = new PaternalGrandFatherResponse( resultList );


//        result

//        resultList.stream()
//                .map (tuple -> {
//                    PaternalGrandFatherResponse  pr = new PaternalGrandFatherResponse();
//                    pr.setPaternalId(tuple.get);
//
//                    return null;
//
//                });

        return p ;
    }
}

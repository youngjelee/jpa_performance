package com.allmytour.ai.app.mock.v2.repository.custom;

import com.allmytour.ai.app.mock.v2.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.allmytour.ai.app.mock.v2.entity.QBaby.baby;
import static com.allmytour.ai.app.mock.v2.entity.QFather.father;
import static com.allmytour.ai.app.mock.v2.entity.QMother.mother;

@RequiredArgsConstructor
public class BabyRepositoryImpl implements BabyRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    @Override
    public Page<Baby> findBabiesByQueryDsl(String name, String fatherName, String motherName, Pageable pageable) {

        List<Baby> results = queryFactory
                .selectFrom(baby)
                .where(
                        name != null ? baby.name.eq(name) : null,
                        fatherName != null ? baby.father.name.eq(fatherName) : null,
                        motherName != null ? baby.mother.name.eq(motherName) : null
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .selectFrom(baby)
                .where(
                        name != null ? baby.name.eq(name) : null,
                        fatherName != null ? baby.father.name.eq(fatherName) : null,
                        motherName != null ? baby.mother.name.eq(motherName) : null

                )
                .fetchCount();

        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public Page<Baby> findBabiesByQueryDsl2(String name, String fatherName, String motherName, Pageable pageable) {

        List<Baby> results = queryFactory
                .select(baby)
                .from( baby)
                .join( baby.father , father ).fetchJoin()
                .join( father.paternalGrandFather , QPaternalGrandFather.paternalGrandFather ).fetchJoin()
                .join( father.paternalGrandMother  , QPaternalGrandMother.paternalGrandMother ) .fetchJoin()
                .join( baby.mother , mother ).fetchJoin()
                .join( mother.maternalGrandFather , QMaternalGrandFather.maternalGrandFather ).fetchJoin()
                .join (mother.maternalGrandMother , QMaternalGrandMother.maternalGrandMother) .fetchJoin()
                .where(
                        name != null ? baby.name.eq(name) : null,
                        fatherName != null ? father.name.eq(fatherName) : null,
                        motherName != null ? mother.name.eq(motherName) : null
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .selectFrom(baby)
                .where(
                        name != null ? baby.name.eq(name) : null,
                        fatherName != null ? father.name.eq(fatherName) : null,
                        motherName != null ? mother.name.eq(motherName) : null

                )
                .fetchCount();

        return new PageImpl<>(results, pageable, total);
    }
}

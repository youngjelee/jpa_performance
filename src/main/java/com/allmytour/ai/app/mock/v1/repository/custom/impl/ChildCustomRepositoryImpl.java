package com.allmytour.ai.app.mock.v1.repository.custom.impl;

import com.allmytour.ai.app.mock.v1.domain.Child;
import com.allmytour.ai.app.mock.v1.dto.SearchCriteria;
import com.allmytour.ai.app.mock.v1.repository.custom.ChildCustomRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.allmytour.ai.app.mock.v1.domain.QChild.*;
import static com.allmytour.ai.app.mock.v1.domain.QGrandParent.grandParent;
import static com.allmytour.ai.app.mock.v1.domain.QParent.parent;

@RequiredArgsConstructor
public class ChildCustomRepositoryImpl implements ChildCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Child> findChildByCriteria(SearchCriteria searchCriteria) {

        Child _child = jpaQueryFactory
                .select(child)
                .from(child)
                .join(child.parent , parent).fetchJoin()
                .join(parent.grandParent , grandParent ).fetchJoin()
                .where(
                        inChildIds(searchCriteria.getIds()),
                        inChildNames(searchCriteria.getNames())

                )
                .fetchFirst();

        System.out.println("child:::::::::::" + _child);

        return null;
    }

    private Predicate inChildNames(List<String> names) {
        if( names.isEmpty() ) return null;
        return child.name.in(names);

    }

    private Predicate inChildIds(List<Long> ids) {
        if( ids.isEmpty() ) return null;
        return child.id.in(ids);
    }


}

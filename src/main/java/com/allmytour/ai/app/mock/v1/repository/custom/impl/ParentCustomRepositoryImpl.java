package com.allmytour.ai.app.mock.v1.repository.custom.impl;

import com.allmytour.ai.app.mock.v1.domain.Parent;
import com.allmytour.ai.app.mock.v1.dto.SearchCriteria;
import com.allmytour.ai.app.mock.v1.repository.custom.ParentCustomRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.allmytour.ai.app.mock.v1.domain.QGrandParent.grandParent;
import static com.allmytour.ai.app.mock.v1.domain.QParent.*;

@RequiredArgsConstructor
public class ParentCustomRepositoryImpl implements ParentCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional
    public List<Parent> findParentsByCriteria(SearchCriteria searchCriteria) {

        //TODO :: 해당부분 질문 후 진행
        Parent list1 = jpaQueryFactory
                .select(parent )
                .from(parent)
                .join(parent.grandParent, grandParent).fetchJoin()
                .where(
                        inParentIds(searchCriteria.getIds()),
                        inParentNames(searchCriteria.getNames())
                )
                .fetchFirst();






        return null ;

    }

    private Predicate inParentNames(List<String> parentNames) {
        if( parentNames.isEmpty()) return null;
        return parent.name.in(parentNames);
    }

    private BooleanExpression inParentIds(List<Long> ids ) {
        if( ids.isEmpty()) return null;
        return parent.id.in(ids);
    }
}

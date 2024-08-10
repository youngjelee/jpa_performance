package com.allmytour.ai.app.mock.v1.repository.custom;

import com.allmytour.ai.app.mock.v1.domain.Child;
import com.allmytour.ai.app.mock.v1.dto.SearchCriteria;

import java.util.List;

public interface ChildCustomRepository {

    public List<Child> findChildByCriteria(SearchCriteria searchCriteria) ;
}

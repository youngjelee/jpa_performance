package com.allmytour.ai.app.mock.v1.repository.custom;

import com.allmytour.ai.app.mock.v1.domain.Parent;
import com.allmytour.ai.app.mock.v1.dto.SearchCriteria;

import java.util.List;

public interface ParentCustomRepository {

    List<Parent> findParentsByCriteria(SearchCriteria searchCriteria);
}

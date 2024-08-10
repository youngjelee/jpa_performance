package com.allmytour.ai.app.mock.v1.repository.custom;

import com.allmytour.ai.app.mock.v1.domain.GrandParent;

public interface GrandParentCustomRepository {

    GrandParent getRandomGrandParent();

    GrandParent getGrandParent(Long id);
}

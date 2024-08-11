package com.allmytour.ai.app.mock.v2.repository.custom;

import com.allmytour.ai.app.mock.v2.dto.res.PaternalGrandFatherResponse;
import com.allmytour.ai.app.mock.v2.entity.PaternalGrandFather;

public interface PaternalFatherRepositoryCustom {

    PaternalGrandFatherResponse getPaternalGrandFatherById(Long id) ;
}

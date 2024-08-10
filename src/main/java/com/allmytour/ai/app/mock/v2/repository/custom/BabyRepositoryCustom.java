package com.allmytour.ai.app.mock.v2.repository.custom;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BabyRepositoryCustom {

    Page<Baby> findBabiesByQueryDsl(String name, String fatherName, String motherName, Pageable pageable);

    Page<Baby> findBabiesByQueryDsl2(String name, String fatherName, String motherName, Pageable pageable);

}

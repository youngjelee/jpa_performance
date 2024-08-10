package com.allmytour.ai.app.mock.v2.repository;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.repository.custom.BabyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BabyRepository extends JpaRepository<Baby,Long> , BabyRepositoryCustom, JpaSpecificationExecutor<Baby> {
}

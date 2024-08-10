package com.allmytour.ai.app.mock.v1.repository;

import com.allmytour.ai.app.mock.v1.domain.GrandParent;
import com.allmytour.ai.app.mock.v1.repository.custom.GrandParentCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrandParentRepository extends JpaRepository<GrandParent, Long> , GrandParentCustomRepository {
}

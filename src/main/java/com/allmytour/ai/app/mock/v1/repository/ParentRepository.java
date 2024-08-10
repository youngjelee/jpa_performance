package com.allmytour.ai.app.mock.v1.repository;

import com.allmytour.ai.app.mock.v1.domain.Parent;
import com.allmytour.ai.app.mock.v1.repository.custom.ParentCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> , ParentCustomRepository {
}

package com.allmytour.ai.app.mock.v1.repository;

import com.allmytour.ai.app.mock.v1.domain.Child;
import com.allmytour.ai.app.mock.v1.repository.custom.ChildCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> , ChildCustomRepository {
}

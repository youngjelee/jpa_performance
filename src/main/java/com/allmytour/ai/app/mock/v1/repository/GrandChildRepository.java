package com.allmytour.ai.app.mock.v1.repository;

import com.allmytour.ai.app.mock.v1.domain.GrandChild;
import com.allmytour.ai.app.mock.v1.repository.custom.GrandChildCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrandChildRepository extends JpaRepository<GrandChild, Long> , GrandChildCustomRepository {
}

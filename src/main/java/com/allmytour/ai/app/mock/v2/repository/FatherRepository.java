package com.allmytour.ai.app.mock.v2.repository;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.entity.Father;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FatherRepository extends JpaRepository<Father,Long> {
}

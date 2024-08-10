package com.allmytour.ai.app.mock.v2.repository;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.entity.Mother;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotherRepository extends JpaRepository<Mother,Long> {
}

package com.allmytour.ai.app.mock.v2.repository;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.entity.PaternalGrandFather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaternalFatherRepository extends JpaRepository<PaternalGrandFather,Long> {
}

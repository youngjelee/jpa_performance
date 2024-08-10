package com.allmytour.ai.app.mock.v2.repository;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.entity.MaternalGrandMother;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaternalMotherRepository extends JpaRepository<MaternalGrandMother,Long> {
}

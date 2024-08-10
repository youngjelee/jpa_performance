package com.allmytour.ai.app.mock.v2.repository;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.entity.PaternalGrandMother;
import com.allmytour.ai.app.mock.v2.repository.custom.BabyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaternalMotherRepository extends JpaRepository<PaternalGrandMother,Long>  {
}

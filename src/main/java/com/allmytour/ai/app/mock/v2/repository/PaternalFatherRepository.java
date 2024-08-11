package com.allmytour.ai.app.mock.v2.repository;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.entity.PaternalGrandFather;
import com.allmytour.ai.app.mock.v2.repository.custom.PaternalFatherRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaternalFatherRepository extends JpaRepository<PaternalGrandFather,Long> , PaternalFatherRepositoryCustom {
}

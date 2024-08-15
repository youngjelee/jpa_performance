package com.allmytour.ai.app.mock.v3.repository;

import com.allmytour.ai.app.mock.v3.entity.NoForienTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoForeienRepository extends JpaRepository<NoForienTest, Long> , NoForCustom{

}

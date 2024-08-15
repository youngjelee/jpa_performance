package com.allmytour.ai.app.mock.v3.repository;

import com.allmytour.ai.app.mock.v3.entity.Test1;
import com.allmytour.ai.app.mock.v3.entity.Test2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Test2Repository extends JpaRepository<Test2, Long> ,Test2RepositoryCustom{
}

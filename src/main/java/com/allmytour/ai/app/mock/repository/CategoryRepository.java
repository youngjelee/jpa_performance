package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.Category;
import com.allmytour.ai.app.mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

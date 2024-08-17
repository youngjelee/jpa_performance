package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.User;
import com.allmytour.ai.app.mock.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}

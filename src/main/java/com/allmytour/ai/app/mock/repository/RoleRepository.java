package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.Role;
import com.allmytour.ai.app.mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

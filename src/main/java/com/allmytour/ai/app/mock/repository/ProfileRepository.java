package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.Profile;
import com.allmytour.ai.app.mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}

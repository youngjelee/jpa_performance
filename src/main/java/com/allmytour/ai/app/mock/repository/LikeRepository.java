package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.Like;
import com.allmytour.ai.app.mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}

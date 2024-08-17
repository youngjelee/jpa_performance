package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.PostTag;
import com.allmytour.ai.app.mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
}

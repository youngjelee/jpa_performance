package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.Tag;
import com.allmytour.ai.app.mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);

    @Query("SELECT t FROM Tag t LEFT JOIN FETCH t.posts WHERE t.id = :id")
    Optional<Tag> findByIdWithPosts(@Param("id") Long id);
}

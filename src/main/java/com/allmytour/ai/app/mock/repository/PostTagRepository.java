package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.PostTag;
import com.allmytour.ai.app.mock.entity.Tag;
import com.allmytour.ai.app.mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {

    List<PostTag> findByPostId(Long postId);

    List<Tag> findByTagId(Long tagId);
}

package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.Post;
import com.allmytour.ai.app.mock.repository.custom.PostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> , PostRepositoryCustom {

//    List<Post>

    List<Post> findByTags_Id(Long id) ;

    List<Post> findByTags_Tag_Name(String name) ;

}

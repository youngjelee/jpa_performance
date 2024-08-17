package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.dto.CommentDTO;
import com.allmytour.ai.app.mock.entity.Comment;
import com.allmytour.ai.app.mock.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // DTO 로 반환
    @Query(" select new com.allmytour.ai.app.mock.dto.CommentDTO (c.id , c.content)  from Comment c where c.id = :id" )
    CommentDTO searchByIdPartialComment (Long id );

//    Comment findByPost(Post post);

    List<Comment> findByPost_Id(Long id );

}

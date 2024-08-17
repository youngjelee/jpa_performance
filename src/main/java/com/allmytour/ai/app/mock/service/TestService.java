package com.allmytour.ai.app.mock.service;

import com.allmytour.ai.app.mock.entity.Comment;
import com.allmytour.ai.app.mock.entity.Post;
import com.allmytour.ai.app.mock.entity.User;
import com.allmytour.ai.app.mock.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class TestService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostTagRepository postTagRepository;
    @Autowired TagRepository tagRepository;



    public void getComments(){
        Optional<Comment> opComment  = commentRepository.findById(17L);

        System.out.println("============");
        System.out.println("============");
        System.out.println("============");
        Comment comment = opComment.get();
        User user = comment.getUser();
        user.setUsername("lee");
        User testUser = userRepository.save(user);

        Post post = comment.getPost();

        System.out.println("====================") ;



    }



}

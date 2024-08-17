package com.allmytour.ai;

import com.allmytour.ai.app.mock.dto.CommentDTO;
import com.allmytour.ai.app.mock.entity.*;
import com.allmytour.ai.app.mock.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class Test1 {

    @Autowired UserRepository userRepository;
    @Autowired CategoryRepository categoryRepository;
    @Autowired PostRepository postRepository;
    @Autowired CommentRepository commentRepository;
    @Autowired PostTagRepository postTagRepository;
    @Autowired TagRepository tagRepository;



    @Test
    public void testSimplePost(){
        Post p = postRepository.findById(5L).get();

        System.out.println("===");

    }


    @Test // repository 를 통해 조인 은 성공 .. but , 엔티티 자체가 가지고
    // field 값에는 필터가 적용되지 않는다.. 당연 한것 .
    public void simpleFindPost_V2() {

        List<Post> _list = postRepository.findByTags_Tag_Name("게임");

        System.out.println("-------");

    }

    @Test // 내부객체와 조인 후 FILTER 값 비교
    public void simpleFindPost() {

        List<Post> _list = postRepository.findByTags_Id( 1L);

        System.out.println("-------");

    }


    @Test // JPA repoistoy 를 통한 네이밍메소드 조인 테스트
    public void simpleFindPostId (){

//        Post p = postRepository.findById(4L).get();

//        Comment c  = commentRepository.findPo

        List<Comment> commentList = commentRepository.findByPost_Id(4L);

        System.out.println("===========");
    }



    @Test
    public void getPartialComment () {
       CommentDTO c =  commentRepository.searchByIdPartialComment(17L);

       System.out.println("=======");

    }



    @Test
    public void makePostTag (){
         Optional<Tag> t = tagRepository.findByIdWithPosts(1L);


         System.out.print("aaaaa");

    }
    @Test
    public void savePostTag(){



        Post np = Post.builder()
                .user(userRepository.findById(1L).get())
                .title("test")
                .content("test")
                .category(categoryRepository.findById(1L).get())
                .build();
        postRepository.save(np);
//
        Tag tag = Tag.builder()
                .name("테스트태그")
                .build();
        tagRepository.save(tag);
//
        PostTag pt  = PostTag.builder()
                .post(np)
                .tag(tag)
                .build();
        postTagRepository.save(pt);



        System.out.println("============");
        System.out.println("============");
        System.out.println("============");
    }


    @Test
    public void createPostWithTag(){

//        User u = userRepository.findById(1L).get();
//        Tag tag = this.ifNoExistsMakeTag("여행");
//        Post p = Post.builder().user(u).title("test1").content("content2").build();
//        PostTag postTag = PostTag.builder()
//                .post()
//                .build();


//        Tag t = tagRepository.findById(1L).get();
//        tagRepository.findById(2L).get();
//        tagRepository.findById(3L).get();
//
//
//        List<PostTag> postTags = new ArrayList<>() ;
//
//
//
//        Post p = Post.builder()
//                .user(u)
//                .title("테스트")
//                .content("내용")
//                .tags()
//                .build();
//
//        postRepository.save()
    }

    private Tag ifNoExistsMakeTag(String tagName) {

        Optional<Tag> tag = tagRepository.findByName(tagName);
        if( tag.isEmpty() ) {
            Tag _tmpTag = Tag.builder()
                    .name(tagName)
                    .build();
            Tag resultTag = tagRepository.save(_tmpTag);
            return resultTag;
        }
        return tag.get();


    }

    @Test
    public void createComment(){

//        List<Post> postList = postRepository.findAll()
//
//        for (Post p : postList ) {
//            Comment c = new Comment();
//        }
        Post p = postRepository.findById(1L).get();
        User u = userRepository.findById(1L).get();

        Comment c = Comment.builder()
                .content("댓글1")
                .user(u)
                .post(p)
                .build();
        commentRepository.save(c);

    }

    @Test

    public void createPost(){

                Post p = postRepository.findById((long) 4 ).get();

                User user = userRepository.findById( (long) 1).get();

                List<Comment>  comments = new ArrayList<>();

                Comment comment1 = Comment.builder()
                        .user(user)
                        .content("내용이요3")
                        .post(p)
                        .build();

                Comment comment2 = Comment.builder()
                        .user(user)
                        .content("내용이요24")
                        .post(p)
                        .build();

                comments.add(comment1);
                comments.add(comment2);

                p.addComment(comments);


                postRepository.save(p);

                System.out.println("aaa") ;
//            }
//        }
    }

    @Test
    public void removePost(){

        postRepository.deleteById(3L);
    }

    @Test
    public void createUser(){

        for ( int i = 0 ;i < 100 ; i ++ ) {
            Address address = new Address("street"+i , "city"+i , "state"+i , "country"+i ) ;

            User user = User.builder()
                    .address(address)
                    .email( "email_"+i+".com")
                    .username("username_"+ i )
                    .build();
            userRepository.save(user);

        }
    }


    @Test
    public void makeCategroy (){
        for (int i = 0 ;i < 10 ; i++ ) {
            Category c = new Category() ;
            c.setName("category_"+ i );
            categoryRepository.save(c);
        }
    }


    @Test
    public void getPost(){
        Optional<Post> post =  postRepository.findById(4L);

        System.out.println("============");
        System.out.println("============");
        System.out.println("============");
    }

    @Test
    public void getComments(){
        Optional<Comment> opComment  = commentRepository.findById(17L);

        System.out.println("============");
        System.out.println("============");
        System.out.println("============");
        Comment comment = opComment.get();
        User user = comment.getUser();
        user.setUsername("lee");
        userRepository.save(user);

        Post post = comment.getPost();

        System.out.println("====================") ;

    }

}

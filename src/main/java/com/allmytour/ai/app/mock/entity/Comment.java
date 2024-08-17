package com.allmytour.ai.app.mock.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


//    public static Comment makeComment(String content ,User user ,Post post ) {
//        Comment comment = Comment.builder()
//                .content(content)
//                .user(user)
//                .post(post)
//                .build();
//        return comment;
//    }

}
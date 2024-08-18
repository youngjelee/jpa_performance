package com.allmytour.ai.app.mock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostResponseDto {

    private Long postId;
    private String title;
    private String content;
    private Long userId;
    private String username;
    private String userEmail;
    private Long categoryId;
    private String categoryName;


}

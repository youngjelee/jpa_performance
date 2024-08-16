package com.allmytour.ai.app.mock;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    // 추가적인 속성 (예: 생성일, 상태 등)
    private LocalDateTime createdDate;
}

package com.allmytour.ai.app.mock;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;
@Entity
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private User friend;

    private LocalDateTime createdDate;
}
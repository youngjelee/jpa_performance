package com.allmytour.ai.app.mock;
import jakarta.persistence.*;import java.util.*;
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String avatarUrl;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}

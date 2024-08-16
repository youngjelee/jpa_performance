package com.allmytour.ai.app.mock;

import jakarta.persistence.*;import java.util.*;
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Post> posts = new ArrayList<>();
}

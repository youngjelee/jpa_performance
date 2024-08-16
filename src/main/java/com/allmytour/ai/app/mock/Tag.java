package com.allmytour.ai.app.mock;
import jakarta.persistence.*;
import java.util.*;
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostTag> posts = new ArrayList<>();
}
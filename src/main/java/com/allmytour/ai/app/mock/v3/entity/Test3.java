package com.allmytour.ai.app.mock.v3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Test3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "test2_id")
    private Test2 test2;
}

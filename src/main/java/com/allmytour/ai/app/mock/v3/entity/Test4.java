package com.allmytour.ai.app.mock.v3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Test4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "test3_id")
    private Test3 test3;
}

package com.allmytour.ai.app.mock.v3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Test5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "test4_id")
    private Test4 test4;
}

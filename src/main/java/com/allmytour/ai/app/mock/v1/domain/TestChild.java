package com.allmytour.ai.app.mock.v1.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "test_child")
public class TestChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

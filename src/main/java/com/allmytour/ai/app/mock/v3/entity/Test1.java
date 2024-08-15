package com.allmytour.ai.app.mock.v3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Test1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
}

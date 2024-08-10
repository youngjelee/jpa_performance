package com.allmytour.ai.app.mock.v2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "maternal_grand_father")
@Data
public class MaternalGrandFather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maternal_grand_father_id")
    private Long id;

    private String name;

}

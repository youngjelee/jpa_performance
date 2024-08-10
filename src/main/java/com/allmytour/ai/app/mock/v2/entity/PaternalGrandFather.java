package com.allmytour.ai.app.mock.v2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "paternal_grand_father")
@Data
public class PaternalGrandFather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paternal_grand_father_id")
    private Long id;
    private String name;

}

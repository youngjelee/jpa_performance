package com.allmytour.ai.app.mock.v2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "father")
@Data
public class Father {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "father_id")
    private Long id;

    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name="up_fahter_id")
    private PaternalGrandFather paternalGrandFather;
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name="up_mother_id")
    private PaternalGrandMother paternalGrandMother;

    private String name;
}

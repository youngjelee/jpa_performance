package com.allmytour.ai.app.mock.v2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mother")

public class Mother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mother_id")
    private Long id;
    private String name;

    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name="up_fahter_id")
    private MaternalGrandFather maternalGrandFather;
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name="up_mother_id")
    private MaternalGrandMother maternalGrandMother;


}

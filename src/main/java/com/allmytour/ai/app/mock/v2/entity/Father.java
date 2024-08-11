package com.allmytour.ai.app.mock.v2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "father")

public class Father {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "father_id")
    private Long id;

    @JsonIgnore
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name="up_fahter_id")
    private PaternalGrandFather paternalGrandFather;

    @JsonIgnore
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name="up_mother_id")
    private PaternalGrandMother paternalGrandMother;

    @OneToMany (mappedBy = "father")
    private List<Baby> babyList;

    private String name;

}

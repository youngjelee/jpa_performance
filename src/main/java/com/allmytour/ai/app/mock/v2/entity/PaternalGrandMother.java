package com.allmytour.ai.app.mock.v2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paternal_grand_mother")

public class PaternalGrandMother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paternal_grand_mother_id")
    private Long id;

    private String name;

//    @JsonIgnore
    @OneToMany(mappedBy = "paternalGrandMother")
    private List<Father> fathers = new ArrayList<>();



}

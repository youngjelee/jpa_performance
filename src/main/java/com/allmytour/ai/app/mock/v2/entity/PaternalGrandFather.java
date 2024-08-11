package com.allmytour.ai.app.mock.v2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paternal_grand_father")

//@ToString( of = {"id" , "name"})
public class PaternalGrandFather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paternal_grand_father_id")
    private Long id;
    private String name;

//    @JsonIgnore
    @OneToMany( mappedBy = "paternalGrandFather")
    private List<Father> fathers = new ArrayList<>();


}

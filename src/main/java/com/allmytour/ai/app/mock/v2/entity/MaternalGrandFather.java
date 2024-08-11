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
@Table(name = "maternal_grand_father")

public class MaternalGrandFather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maternal_grand_father_id")
    private Long id;

    private String name;

}

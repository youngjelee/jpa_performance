package com.allmytour.ai.app.mock.v2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "baby")

//@ToString( of ={"id","name","parent" })
public class Baby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baby_id")
    private Long id;

    @JsonIgnore
    @ManyToOne  ( fetch = FetchType.LAZY)
    @JoinColumn(name="fahter_id")
    private Father father;

    @ManyToOne  ( fetch = FetchType.LAZY)
    @JoinColumn(name="mother_id")
    private Mother mother;

//    @OneToMany


    private String name;

}

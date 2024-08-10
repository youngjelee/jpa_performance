package com.allmytour.ai.app.mock.v2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "baby")
@Data
//@ToString( of ={"id","name","parent" })
public class Baby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baby_id")
    private Long id;

    @ManyToOne // ( fetch = FetchType.LAZY)
    @JoinColumn(name="fahter_id")
    private Father father;

    @ManyToOne // ( fetch = FetchType.LAZY)
    @JoinColumn(name="mother_id")
    private Mother mother;

    private String name;

}

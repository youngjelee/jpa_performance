package com.allmytour.ai.app.mock.v1.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "grand_child")
@Data
@ToString( of ={"id","name","child" })
public class GrandChild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grand_child_id")
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn(name="child_id" , nullable = false )
    private Child child;

    @Comment("이름")
    private String name;
}

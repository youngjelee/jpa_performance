package com.allmytour.ai.app.mock.v1.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name = "child")
@Data
@ToString( of ={"id","name","parent" })
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Long id;

    @OneToMany(mappedBy = "child")
    private List<GrandChild> grandChilds;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name="parent_id" , nullable = false )
    private Parent parent;

    @Comment("이름")
    private String name;

}

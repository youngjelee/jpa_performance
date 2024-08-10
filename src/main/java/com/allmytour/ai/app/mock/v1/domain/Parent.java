package com.allmytour.ai.app.mock.v1.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Table(name = "parent")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@ToString( of ={"id","name","grandParent" })
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Long id;

    @OneToMany ( mappedBy="parent" , cascade =  CascadeType.ALL , orphanRemoval = true )
    private List<Child> childs;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name="grand_parent_id" , nullable = false )
    private GrandParent grandParent;

    @Comment("이름")
    private String name;


}

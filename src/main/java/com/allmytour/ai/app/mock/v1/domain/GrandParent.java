package com.allmytour.ai.app.mock.v1.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Table(name = "grand_parent")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@ToString( of ={"id","name" })
public class GrandParent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grand_parent_id")
    private Long id;
    @OneToMany(mappedBy = "grandParent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parent> parents;
    @Comment("이름")
    private String name;



}

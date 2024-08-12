package com.allmytour.ai.app.mock.v3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;

    @Column(columnDefinition = "BIGINT DEFAULT 0")
    private Long price;

    @Column(columnDefinition = "BIGINT DEFAULT 0")
    private Long count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "seller_id")
    private Member member;


    public  void minusStock( Long reqStock ) {
        this.count -=  reqStock;
    }
}

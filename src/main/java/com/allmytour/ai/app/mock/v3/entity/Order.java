package com.allmytour.ai.app.mock.v3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private String name;

    @ManyToOne  ( fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    // 전체 인자를 받는 생성자
    public Order(String name, Member member) {
        this.name = name;
        this.member = member;
    }

    // Getter 및 Setter 생략

    public static Order makeOrder(String orderName, Member m) {
        return new Order(orderName, m);
    }
}

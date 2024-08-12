package com.allmytour.ai.app.mock.v3.entity;

import com.allmytour.ai.app.mock.v3.dto.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item")
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn( name = "order_id")
    private Order order;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn( name = "item_id")
    private Item item;

    private Long quantity;

    public OrderItem( Order order , Item item , Long quantity ) {
        this.order = order ;
        this.item = item;
        this.quantity = quantity;
    }

    public  static OrderItem makeOrderItem(Order order , Item item , ItemDto reqItemDto) {
        OrderItem orderItem = new OrderItem( order ,item ,reqItemDto.getQuantity()) ;
        return orderItem;
    }
}

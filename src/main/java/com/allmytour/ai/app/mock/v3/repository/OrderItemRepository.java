package com.allmytour.ai.app.mock.v3.repository;

import com.allmytour.ai.app.mock.v3.entity.Item;
import com.allmytour.ai.app.mock.v3.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

package com.rishmi5h.microservices.order.repository;

import com.rishmi5h.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

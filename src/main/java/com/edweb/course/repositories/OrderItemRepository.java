package com.edweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edweb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

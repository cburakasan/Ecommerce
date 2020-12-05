package com.baeldung.ecommerce.eski.repository;

import com.baeldung.ecommerce.eski.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}

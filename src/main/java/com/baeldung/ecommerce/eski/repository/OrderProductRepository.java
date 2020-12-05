package com.baeldung.ecommerce.eski.repository;

import com.baeldung.ecommerce.eski.model.OrderProduct;
import com.baeldung.ecommerce.eski.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}

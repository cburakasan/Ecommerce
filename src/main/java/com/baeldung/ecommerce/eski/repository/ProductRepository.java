package com.baeldung.ecommerce.eski.repository;

import com.baeldung.ecommerce.eski.model.ProductOld;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductOld, Long> {
}

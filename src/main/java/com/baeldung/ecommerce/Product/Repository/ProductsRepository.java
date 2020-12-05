package com.baeldung.ecommerce.Product.Repository;

import com.baeldung.ecommerce.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Long> {
}

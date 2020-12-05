package com.baeldung.ecommerce.eski.service;

import com.baeldung.ecommerce.eski.model.ProductOld;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<ProductOld> getAllProducts();

    ProductOld getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    ProductOld save(ProductOld product);
}

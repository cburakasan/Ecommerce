package com.baeldung.ecommerce.eski.controller;

import com.baeldung.ecommerce.eski.model.ProductOld;
import com.baeldung.ecommerce.eski.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<ProductOld> getProducts() {
        return productService.getAllProducts();
    }
}

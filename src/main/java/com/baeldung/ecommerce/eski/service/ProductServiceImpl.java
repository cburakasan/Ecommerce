package com.baeldung.ecommerce.eski.service;

import com.baeldung.ecommerce.eski.exception.ResourceNotFoundException;
import com.baeldung.ecommerce.eski.model.ProductOld;
import com.baeldung.ecommerce.eski.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<ProductOld> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductOld getProduct(long id) {
        return productRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public ProductOld save(ProductOld product) {
        return productRepository.save(product);
    }
}

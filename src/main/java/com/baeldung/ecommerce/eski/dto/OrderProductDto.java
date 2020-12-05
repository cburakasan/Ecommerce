package com.baeldung.ecommerce.eski.dto;

import com.baeldung.ecommerce.eski.model.ProductOld;

public class OrderProductDto {

    private ProductOld product;
    private Integer quantity;

    public ProductOld getProduct() {
        return product;
    }

    public void setProduct(ProductOld product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

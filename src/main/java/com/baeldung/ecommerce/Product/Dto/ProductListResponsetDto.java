package com.baeldung.ecommerce.Product.Dto;

import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.Product.Model.ProductDto;
import lombok.Data;

import java.util.List;

@Data
public class ProductListResponsetDto {
    private List<ProductDto> productList;



}

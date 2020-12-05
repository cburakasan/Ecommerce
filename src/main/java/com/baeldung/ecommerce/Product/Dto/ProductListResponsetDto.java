package com.baeldung.ecommerce.Product.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductListResponsetDto {
    private List<ProductDto> productList;
    private String hataMesaji;



}

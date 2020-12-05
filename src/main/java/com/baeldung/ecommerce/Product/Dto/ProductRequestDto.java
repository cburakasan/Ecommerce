package com.baeldung.ecommerce.Product.Dto;

import com.baeldung.ecommerce.Product.Kategori;
import lombok.Data;

import java.io.Serializable;
@Data
public class ProductRequestDto implements Serializable {
    private String kategori;;
    private Long productId;
    private Long userId;

}

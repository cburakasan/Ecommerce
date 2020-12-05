package com.baeldung.ecommerce.Product.Dto;

import com.baeldung.ecommerce.Product.Kategori;
import lombok.Data;


import java.io.Serializable;

@Data
public class ProductResponseDto implements Serializable {
    private Long id;
    private String name;
    private Double price;
    private String pictureUrl;
    private String kategori;
    private String marka;
    private String aciklama;
    private String hataMesaji;
    private boolean kargoBedava;
}

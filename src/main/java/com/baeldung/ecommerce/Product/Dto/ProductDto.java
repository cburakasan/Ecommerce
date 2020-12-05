package com.baeldung.ecommerce.Product.Dto;

import com.baeldung.ecommerce.Product.Kategori;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@ToString(exclude = {"id"})
@EqualsAndHashCode(exclude = {"id"})
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String pictureUrl;
    private String kategori;
    private String marka;
    private String aciklama;
}

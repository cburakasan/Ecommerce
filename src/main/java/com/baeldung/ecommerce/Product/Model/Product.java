package com.baeldung.ecommerce.Product.Model;

import com.baeldung.ecommerce.Product.Kategori;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@ToString(exclude = {"id"})
@EqualsAndHashCode(exclude = {"id"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private String pictureUrl;
    @Enumerated(value = EnumType.STRING)
    private Kategori kategori;
    @Column
    private String marka;
    @Column
    private String aciklama;

    public Product(Long id, @NotNull(message = "Product name is required.") String name, Double price, String pictureUrl, Kategori kategori, String marka, String aciklama) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.kategori=kategori;
        this.marka=marka;
        this.aciklama=aciklama;
    }
    public Product(){

    }
}

package com.baeldung.ecommerce.Favori.Dto;
import com.baeldung.ecommerce.Product.Kategori;
import lombok.Data;
import java.io.Serializable;

@Data
public class FavoriUrunDto implements Serializable {
    private String name;
    private String pictureUrl;
    private String kategori;
    private String marka;
    private String aciklama;
    private Long id;


}

package com.baeldung.ecommerce.Favori.Dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class FavoriEkleRequestDto implements Serializable {
    private Long id;
    private Long productId;
    private Long userId;


}

package com.baeldung.ecommerce.Favori.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FavoriGosterRequestDto implements Serializable {

    private Long userId;

}

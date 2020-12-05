package com.baeldung.ecommerce.Favori.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FavoriEkleResponseDto implements Serializable {
    private String succsessMessage;
    private String hataMesaji;
}

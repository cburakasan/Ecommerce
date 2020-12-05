package com.baeldung.ecommerce.Favori.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FavoriGosterResponseDto implements Serializable {
    private List<FavoriUrunDto> favoriList;

}

package com.baeldung.ecommerce.Favori.Controller;

import com.baeldung.ecommerce.Favori.Dto.FavoriEkleRequestDto;
import com.baeldung.ecommerce.Favori.Dto.FavoriEkleResponseDto;
import com.baeldung.ecommerce.Favori.Dto.FavoriGosterRequestDto;
import com.baeldung.ecommerce.Favori.Dto.FavoriGosterResponseDto;
import com.baeldung.ecommerce.Favori.Service.FavoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/favori")
public class FavoriController {

    @Autowired
    FavoriService favoriService;

    @PostMapping("/ekle")
    public FavoriEkleResponseDto favoriEkle(@RequestBody FavoriEkleRequestDto favoriRequestDto){
        return favoriService.favoriEkle(favoriRequestDto);
    }

    @PostMapping("/listele")
    public FavoriGosterResponseDto favoriGoster(@RequestBody FavoriGosterRequestDto favoriGosterRequestDto){
        return favoriService.favoriGoster(favoriGosterRequestDto);
    }
}

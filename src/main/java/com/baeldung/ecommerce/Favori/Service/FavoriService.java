package com.baeldung.ecommerce.Favori.Service;
import com.baeldung.ecommerce.Favori.Dto.*;
import com.baeldung.ecommerce.Favori.Model.Favori;
import com.baeldung.ecommerce.Favori.Repository.FavoriRepository;
import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.Product.Repository.ProductsRepository;
import com.baeldung.ecommerce.User.Model.User;
import com.baeldung.ecommerce.User.Repository.UserRepositroy;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Log4j
public class FavoriService {

    @Autowired
    ProductsRepository productRepository;

    @Autowired
    UserRepositroy userRepositroy;

    @Autowired
    FavoriRepository favoriRepository;
    public FavoriEkleResponseDto favoriEkle(FavoriEkleRequestDto favoriRequestDto) {
        FavoriEkleResponseDto favoriEkleResponseDto = new FavoriEkleResponseDto();
        try {
            Long productId = favoriRequestDto.getProductId();
            Long userId = favoriRequestDto.getUserId();

            Optional<Product> productOptional = productRepository.findById(productId);
            Product product = productOptional.get();

            Optional<User> userOptional = userRepositroy.findById(userId);
            User user = userOptional.get();

            Favori favori = new Favori();
            favori.setProduct(product);
            favori.setUser(user);
            favoriRepository.save(favori);

        }catch (Exception e){
            String message = e.getMessage();
            log.error(message+"Favori ekleme isleminde bir hata olustu");
            favoriEkleResponseDto.setHataMesaji(message);
            return favoriEkleResponseDto;
        }

        favoriEkleResponseDto.setSuccsessMessage("Favoriye ekleme islemi basarili");


        return favoriEkleResponseDto;
    }

    public FavoriGosterResponseDto favoriGoster(FavoriGosterRequestDto favoriGosterRequestDto) {
        FavoriGosterResponseDto favoriGosterResponseDto = new FavoriGosterResponseDto();
        List<FavoriUrunDto> favoriUrunDtoList = new ArrayList<>();

        Long userId = favoriGosterRequestDto.getUserId();
        Optional<User> userOptional = userRepositroy.findById(userId);
        User user = userOptional.get();

        List<Favori> favoriList = favoriRepository.findAllByUser(user);
        for (Favori favori : favoriList) {
            Product product = favori.getProduct();
            FavoriUrunDto favoriUrunDto= new FavoriUrunDto();
            favoriUrunDto.setMarka(product.getMarka());
            favoriUrunDto.setId(product.getId());
            favoriUrunDto.setAciklama(product.getAciklama());
            favoriUrunDto.setKategori(product.getKategori());
            favoriUrunDtoList.add(favoriUrunDto);
        }
        favoriGosterResponseDto.setFavoriList(favoriUrunDtoList);

        return favoriGosterResponseDto;
    }

}

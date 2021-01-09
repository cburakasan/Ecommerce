package com.baeldung.ecommerce.Product.Service;

import com.baeldung.ecommerce.Favori.Model.Favori;
import com.baeldung.ecommerce.Favori.Repository.FavoriRepository;
import com.baeldung.ecommerce.Order.Model.OrderProductUser;
import com.baeldung.ecommerce.Order.Repository.OrderProductUserRepository;
import com.baeldung.ecommerce.Product.Dto.ProductListResponsetDto;
import com.baeldung.ecommerce.Product.Dto.ProductRequestDto;
import com.baeldung.ecommerce.Product.Dto.ProductResponseDto;
import com.baeldung.ecommerce.Product.Exception.ProductException;
import com.baeldung.ecommerce.Product.Kategori;
import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.Product.Dto.ProductDto;
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
public class ProductService {

    @Autowired
    ProductsRepository productsRepository;






    @Autowired
    UserRepositroy userRepositroy;

    @Autowired
    FavoriRepository favoriRepository;

    public ProductResponseDto productSave(ProductRequestDto productRequestDto) {

        return null;
    }

    public Product save(Product product) {
        return productsRepository.save(product);
    }

    public ProductResponseDto productDetail(ProductRequestDto productRequestDto) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        try {
            Long productId = productRequestDto.getProductId();
            Optional<Product> productOptional = productsRepository.findById(productId);
            if (!productOptional.isPresent()) {
                throw new ProductException("Product bulunamadi", new Exception());
            }

            Product product = productOptional.get();
            String kategori = product.getKategori();
            String marka = product.getMarka();
            String name = product.getName();
            String aciklama = product.getAciklama();
            String pictureUrl = product.getPictureUrl();
            Double price = product.getPrice();
            Long id = product.getId();
            productResponseDto.setKategori(kategori);
            productResponseDto.setMarka(marka);
            productResponseDto.setName(name);
            productResponseDto.setAciklama(aciklama);
            productResponseDto.setPictureUrl(pictureUrl);
            productResponseDto.setPrice(price);
            productResponseDto.setId(id);
            log.info("Product detail basarili");

            Long userId = productRequestDto.getUserId();
            if (userId != null) {
                Optional<User> optionalUser = userRepositroy.findById(userId);
                if (optionalUser.isPresent()) {
                    User user = optionalUser.get();
                    boolean kargoBedava = isKargoBedava(product, user);
                    productResponseDto.setKargoBedava(kargoBedava);
                }
            }

            return productResponseDto;

        } catch (ProductException exception) {
            String message = exception.getMessage();
            log.error(message);
            productResponseDto.setHataMesaji(message);
            return productResponseDto;

        }
    }

    private boolean isKargoBedava(Product product, User user) {
        boolean isKargoBedava = false;
        List<Favori> favoriList = favoriRepository.findAllByProductAndUser(product, user);
        if (favoriList != null && favoriList.size() >0) {
            isKargoBedava = true;

        }
        return isKargoBedava;

    }

    public ProductListResponsetDto findAllProductsByKategori(ProductRequestDto productRequestDto) {
        ProductListResponsetDto productResponseListDto = new ProductListResponsetDto();
        List<ProductDto> productDtos = new ArrayList<>();
        try {
            String kategori = productRequestDto.getKategori();
            List<Product> productList = productsRepository.findAllByKategori(kategori);
            if (productList.size() == 0) {
                throw new ProductException("Bu kateogride ürün bulunamadi", new Exception());
            }
            for (Product product : productList) {
                ProductDto productDto = new ProductDto();
                String kat = product.getKategori();
                String marka = product.getMarka();
                String name = product.getName();
                String aciklama = product.getAciklama();
                String pictureUrl = product.getPictureUrl();
                Double price = product.getPrice();
                Long id = product.getId();
                productDto.setKategori(kat);
                productDto.setMarka(marka);
                productDto.setName(name);
                productDto.setAciklama(aciklama);
                productDto.setPictureUrl(pictureUrl);
                productDto.setPrice(price);
                productDto.setId(id);
                productDtos.add(productDto);
            }
            log.info("Product listeleme basarili");
            productResponseListDto.setProductList(productDtos);

            return productResponseListDto;

        } catch (ProductException exception) {
            String message = exception.getMessage();
            log.error(message);
            productResponseListDto.setHataMesaji(message);
            return productResponseListDto;

        }
    }


    public List<ProductDto> getProductList() {

        List<ProductDto> productDtoList = new ArrayList<>();
        try {
            List<Product> productList = productsRepository.findAll();
            for (Product product : productList) {
                ProductDto productDto = new ProductDto();
                String aciklama = product.getAciklama();
                String kategori = product.getKategori();
                String marka = product.getMarka();
                String name = product.getName();
                String pictureUrl = product.getPictureUrl();
                Double price = product.getPrice();
                Long id = product.getId();
                productDto.setKategori(kategori);
                productDto.setMarka(marka);
                productDto.setName(name);
                productDto.setPictureUrl(pictureUrl);
                productDto.setPrice(price);
                productDto.setId(id);
                productDto.setAciklama(aciklama);
                productDtoList.add(productDto);

            }
        } catch (Exception e) {
            String message = e.getMessage();
            log.error(message, e);
        }
        log.info("Product listeleme basarili");
        return productDtoList;

    }

}
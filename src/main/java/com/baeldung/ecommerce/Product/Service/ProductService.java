package com.baeldung.ecommerce.Product.Service;

import com.baeldung.ecommerce.Product.Dto.ProductListResponsetDto;
import com.baeldung.ecommerce.Product.Dto.ProductRequestDto;
import com.baeldung.ecommerce.Product.Dto.ProductResponseDto;
import com.baeldung.ecommerce.Product.Exception.ProductException;
import com.baeldung.ecommerce.Product.Kategori;
import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.Product.Model.ProductDto;
import com.baeldung.ecommerce.Product.Repository.ProductsRepository;
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
            Kategori kategori = product.getKategori();
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
            return productResponseDto;

        } catch (ProductException exception) {
            String message = exception.getMessage();
            log.error(message);
            productResponseDto.setHataMesaji(message);
            return productResponseDto;

        }
    }


    public List<ProductDto> getProductList() {

        List<ProductDto> productDtoList = new ArrayList<>();
        try {
            List<Product> productList = productsRepository.findAll();
            for (Product product : productList) {
                ProductDto productDto = new ProductDto();
                String aciklama = product.getAciklama();
                Kategori kategori = product.getKategori();
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
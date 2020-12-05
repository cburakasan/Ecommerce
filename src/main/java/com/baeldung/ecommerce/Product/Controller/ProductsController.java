package com.baeldung.ecommerce.Product.Controller;

import com.baeldung.ecommerce.Product.Dto.ProductListResponsetDto;
import com.baeldung.ecommerce.Product.Dto.ProductRequestDto;
import com.baeldung.ecommerce.Product.Dto.ProductResponseDto;
import com.baeldung.ecommerce.Product.Dto.ProductDto;
import com.baeldung.ecommerce.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/product")
public class ProductsController {

    @Autowired
    ProductService productService;

//    public ProductResponseDto productSave(@RequestBody ProductRequestDto productRequestDto){
//        return productService.productSave(productRequestDto);
//    }

    @PostMapping("/detail")
    public ProductResponseDto productDetail(@RequestBody ProductRequestDto productRequestDto){
      return productService.productDetail(productRequestDto);
    }

    @PostMapping("/findAllProductsByKategori")
    public ProductListResponsetDto findAllProductsByKategori(@RequestBody ProductRequestDto productRequestDto){
        return productService.findAllProductsByKategori(productRequestDto);
    }

    @GetMapping("/getList")
    public List<ProductDto> findAllProducts(){
        return productService.getProductList();
    }
}

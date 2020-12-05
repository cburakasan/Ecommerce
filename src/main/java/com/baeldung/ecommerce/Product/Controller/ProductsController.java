package com.baeldung.ecommerce.Product.Controller;

import com.baeldung.ecommerce.Product.Dto.ProductListResponsetDto;
import com.baeldung.ecommerce.Product.Dto.ProductRequestDto;
import com.baeldung.ecommerce.Product.Dto.ProductResponseDto;
import com.baeldung.ecommerce.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
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

    @PostMapping("/getList")
    public ProductListResponsetDto findAllProducts(){
        return productService.getProductList();
    }
}

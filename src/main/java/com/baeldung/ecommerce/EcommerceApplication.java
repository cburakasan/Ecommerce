package com.baeldung.ecommerce;

import com.baeldung.ecommerce.Product.Kategori;
import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.Product.Service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "TV Set", 300.00, "http://placehold.it/200x100", Kategori.TV,"Samsung","55' ekran, 200 Hertz"));
            productService.save(new Product(2L, "Game Console", 200.00, "http://placehold.it/200x100", Kategori.GAME_CONSOLE,"Playstation","500 gb"));
            productService.save(new Product(3L, "Sofa", 100.00, "http://placehold.it/200x100" ,Kategori.EV_ESYASI,"Bellona","acilabilir"));
            productService.save(new Product(4L, "Icecream", 5.00, "http://placehold.it/200x100",Kategori.YIYECEK,"Algida","kesme maras dondurmasi lezzetinde"));
            productService.save(new Product(5L, "Beer", 3.00, "http://placehold.it/200x100",Kategori.ICECEK,"Tuborg","adam gibi bira"));
            productService.save(new Product(6L, "Phone", 500.00, "http://placehold.it/200x100",Kategori.TELEFON,"Iphone","256 Gb"));
            productService.save(new Product(7L, "Watch", 30.00, "http://placehold.it/200x100",Kategori.SAAT,"Rolex","Bir dunya markasi"));
        };
    }
}

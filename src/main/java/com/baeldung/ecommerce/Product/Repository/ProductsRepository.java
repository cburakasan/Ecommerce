package com.baeldung.ecommerce.Product.Repository;

import com.baeldung.ecommerce.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByKategori(String kategori);


}

package com.baeldung.ecommerce.Favori.Repository;

import com.baeldung.ecommerce.Favori.Model.Favori;
import com.baeldung.ecommerce.Order.Model.OrderProductUser;
import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriRepository extends JpaRepository<Favori,Long> {
    List<Favori> findAllByUser(User user);
    List<Favori> findAllByProductAndUser(Product product, User user);

}

package com.baeldung.ecommerce.Favori.Repository;

import com.baeldung.ecommerce.Favori.Model.Favori;
import com.baeldung.ecommerce.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriRepository extends JpaRepository<Favori,Long> {
    List<Favori> findAllByUser(User user);

}

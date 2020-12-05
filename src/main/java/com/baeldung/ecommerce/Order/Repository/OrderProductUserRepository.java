package com.baeldung.ecommerce.Order.Repository;

import com.baeldung.ecommerce.Order.Dto.OrderProductUserRequestDto;
import com.baeldung.ecommerce.Order.Dto.OrderProductUserResponsetDto;
import com.baeldung.ecommerce.Order.Model.OrderProductUser;
import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductUserRepository extends JpaRepository<OrderProductUser, Long> {

}

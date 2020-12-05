package com.baeldung.ecommerce.Order.Repository;

import com.baeldung.ecommerce.Order.Dto.OrderProductUserRequestDto;
import com.baeldung.ecommerce.Order.Dto.OrderProductUserResponsetDto;
import com.baeldung.ecommerce.Order.Model.OrderProductUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductUserRepository extends JpaRepository<OrderProductUser, Long> {


}

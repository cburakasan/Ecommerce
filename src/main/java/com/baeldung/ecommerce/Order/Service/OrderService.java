package com.baeldung.ecommerce.Order.Service;

import com.baeldung.ecommerce.Order.Dto.OrderProductUserRequestDto;
import com.baeldung.ecommerce.Order.Dto.OrderProductUserResponsetDto;
import com.baeldung.ecommerce.Order.Model.Order;
import com.baeldung.ecommerce.Order.Model.OrderProductUser;
import com.baeldung.ecommerce.Order.Repository.OrderProductUserRepository;
import com.baeldung.ecommerce.Order.Repository.OrderRepository;
import com.baeldung.ecommerce.Product.Exception.ProductException;
import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.Product.Repository.ProductsRepository;
import com.baeldung.ecommerce.User.Model.User;
import com.baeldung.ecommerce.User.Repository.UserRepositroy;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Log4j
public class OrderService {
    @Autowired
    OrderProductUserRepository orderProductUserRepository;

    @Autowired
    UserRepositroy userRepositroy;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    OrderRepository orderRepository;

    public OrderProductUserResponsetDto createOrderWithProductUser(OrderProductUserRequestDto orderProductUserRequestDto) {
        OrderProductUserResponsetDto orderProductUserResponsetDto = new OrderProductUserResponsetDto();
        try {
            Long userIdFromDto = orderProductUserRequestDto.getUserId();
            List<Long> productIdList = orderProductUserRequestDto.getProductIdList();
            Long quantity = orderProductUserRequestDto.getQuantity();

            Optional<User> userOptional = userRepositroy.findById(userIdFromDto);//clıenttan dogru deger geldıgı ve dolu gelmesi lazım.
            User user = userOptional.get();

            Order order = new Order();
            order.setStatus("Beklemede");
            order.setDateCreated(new Date());
            order = orderRepository.save(order);

            for (Long productId : productIdList) {
                OrderProductUser orderProductUser = new OrderProductUser();

                Optional<Product> optionalProduct = productsRepository.findById(productId);
                Product product = optionalProduct.get();

                orderProductUser.setOrder(order);
                orderProductUser.setProduct(product);
                orderProductUser.setUser(user);
                orderProductUser.setQuantity(quantity);

                orderProductUserRepository.save(orderProductUser);

            }
        } catch (Exception exception) {
            String message = "Sipariş olusturulamadı + ex: " + exception.getMessage();
            log.error(message);
            orderProductUserResponsetDto.setHataMesaji(message);
            return orderProductUserResponsetDto;

        }

        return orderProductUserResponsetDto;

    }
}

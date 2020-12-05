package com.baeldung.ecommerce.Order.Controller;

import com.baeldung.ecommerce.Order.Dto.OrderProductUserRequestDto;
import com.baeldung.ecommerce.Order.Dto.OrderProductUserResponsetDto;
import com.baeldung.ecommerce.Order.Repository.OrderProductUserRepository;
import com.baeldung.ecommerce.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public OrderProductUserResponsetDto createOrderWithProductUser(@RequestBody OrderProductUserRequestDto orderProductUserRequestDto){
       return orderService.createOrderWithProductUser(orderProductUserRequestDto);

    }


}

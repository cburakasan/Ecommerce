package com.baeldung.ecommerce.Order.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderProductUserRequestDto implements Serializable {
    private Long userId;
    private List<Long> productIdList;
    private Long quantity;

}

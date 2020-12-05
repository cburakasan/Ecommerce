package com.baeldung.ecommerce.comment.Dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CommentRequestDto implements Serializable {
    private Long productId;
    private Long userId;
    private String yorum;


}

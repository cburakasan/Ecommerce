package com.baeldung.ecommerce.comment.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentResponseDto implements Serializable {
    private String succsessMessage;
    private String hataMesaji;
}

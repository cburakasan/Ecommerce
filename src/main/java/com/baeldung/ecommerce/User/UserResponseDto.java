package com.baeldung.ecommerce.User;

import lombok.Data;

@Data
public class UserResponseDto {
    private String hataMessage;
    private Long id;
    private String username;
    private String password;
    private String email;
    private String gsm;
}

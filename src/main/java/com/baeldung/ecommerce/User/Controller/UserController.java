package com.baeldung.ecommerce.User.Controller;

import com.baeldung.ecommerce.User.Dto.UserRequestDto;
import com.baeldung.ecommerce.User.Dto.UserResponseDto;
import com.baeldung.ecommerce.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public UserResponseDto userRegister(@RequestBody UserRequestDto userRequestDto){
       return userService.userRegister(userRequestDto);
    }
    @PostMapping("/login")
    public UserResponseDto userLogin(@RequestBody UserRequestDto userRequestDto){

        return userService.userGiris(userRequestDto);

    }


}

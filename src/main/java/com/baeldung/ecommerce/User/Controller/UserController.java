package com.baeldung.ecommerce.User.Controller;

import com.baeldung.ecommerce.User.Dto.UserRequestDto;
import com.baeldung.ecommerce.User.Dto.UserResponseDto;
import com.baeldung.ecommerce.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/userregister")
    public UserResponseDto userRegister(@RequestBody UserRequestDto userRequestDto){
       return userService.userRegister(userRequestDto);
    }
    @PostMapping("/userlogin")
    public UserResponseDto userLogin(@RequestBody UserRequestDto userRequestDto){

        return userService.userGiris(userRequestDto);

    }


}

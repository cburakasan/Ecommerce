package com.baeldung.ecommerce.User;

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

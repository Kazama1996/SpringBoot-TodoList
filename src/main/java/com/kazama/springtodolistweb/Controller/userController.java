package com.kazama.springtodolistweb.Controller;


import com.kazama.springtodolistweb.Service.UserService;
import com.kazama.springtodolistweb.dto.UserLoginRequest;
import com.kazama.springtodolistweb.dto.UserRegisterRequest;
import com.kazama.springtodolistweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest){
        Integer userId = userService.register(userRegisterRequest);

        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody UserLoginRequest userLoginRequest){

        User user  = userService.login(userLoginRequest);

        return ResponseEntity.status(HttpStatus.OK).body(user);

    }
}

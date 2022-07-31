package com.kazama.springtodolistweb.Service;

import com.kazama.springtodolistweb.dto.UserLoginRequest;
import com.kazama.springtodolistweb.dto.UserRegisterRequest;
import com.kazama.springtodolistweb.model.User;

public interface UserService {

    public Integer register(UserRegisterRequest userRegisterRequest);

    public User getUserById(Integer userId);

    public User login( UserLoginRequest userLoginRequest);
}

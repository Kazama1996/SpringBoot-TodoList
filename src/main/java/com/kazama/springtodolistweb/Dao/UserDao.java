package com.kazama.springtodolistweb.Dao;

import com.kazama.springtodolistweb.dto.UserLoginRequest;
import com.kazama.springtodolistweb.dto.UserRegisterRequest;
import com.kazama.springtodolistweb.model.User;

public interface UserDao {

    public Integer create_user(UserRegisterRequest userRegisterRequest);

    public User getUserById(Integer userId);

    public User getUserByAccount(String account);

    public User login(UserLoginRequest userLoginRequest);
}

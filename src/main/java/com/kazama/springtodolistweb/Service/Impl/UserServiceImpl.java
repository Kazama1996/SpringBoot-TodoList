package com.kazama.springtodolistweb.Service.Impl;

import com.kazama.springtodolistweb.Dao.UserDao;
import com.kazama.springtodolistweb.Service.UserService;
import com.kazama.springtodolistweb.dto.UserLoginRequest;
import com.kazama.springtodolistweb.dto.UserRegisterRequest;
import com.kazama.springtodolistweb.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;


    public Integer register(UserRegisterRequest userRegisterRequest){
        User user = userDao.getUserByAccount(userRegisterRequest.getUser_account());

        if(user!=null){
            log.warn("Email {} 已經被註冊", userRegisterRequest.getUser_account());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }


        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getUser_password().getBytes());


        userRegisterRequest.setUser_password(hashedPassword);


        return userDao.create_user(userRegisterRequest);
    }

    public User getUserById(Integer userId){

        return userDao.getUserById(userId);
    }

    public User login(UserLoginRequest userLoginRequest){

        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getUser_password().getBytes());

        userLoginRequest.setUser_password(hashedPassword);

        User user = userDao.login(userLoginRequest);


        if(user==null){
            log.warn("登錄失敗");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        else return user;
    }
}

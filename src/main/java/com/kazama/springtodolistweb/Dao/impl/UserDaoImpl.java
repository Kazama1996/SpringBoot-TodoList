package com.kazama.springtodolistweb.Dao.impl;

import com.kazama.springtodolistweb.Dao.UserDao;
import com.kazama.springtodolistweb.RowMapper.UserRowMapper;
import com.kazama.springtodolistweb.dto.UserLoginRequest;
import com.kazama.springtodolistweb.dto.UserRegisterRequest;
import com.kazama.springtodolistweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer create_user(UserRegisterRequest userRegisterRequest){
        String sql ="INSERT INTO `user` (user_account,  user_password , created_date , last_modified_date) VALUES(:user_account,:user_password,:created_date,:last_modified_date)";

        Map<String,Object> map = new HashMap<>();

        map.put("user_account" , userRegisterRequest.getUser_account());
        map.put("user_password" , userRegisterRequest.getUser_password());
        map.put("created_date" , new Date());
        map.put("last_modified_date" , new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql ,new MapSqlParameterSource(map) , keyHolder);

        int key = keyHolder.getKey().intValue();


        return key ;

    }

    public User getUserById(Integer userId){
        String sql = "SELECT user_id , user_account ,user_password, created_date , last_modified_date FROM `user` WHERE user_id = :user_id";

        Map<String , Object> map = new HashMap<>();

        map.put("user_id" ,  userId);

        List<User> userList = namedParameterJdbcTemplate.query(sql , new MapSqlParameterSource(map) ,new UserRowMapper());

        if(userList.size()>0){
            return userList.get(0);
        }
        else return null ;

    }

    public User getUserByAccount(String account){
        String sql = "SELECT user_id , user_account ,user_password, created_date , last_modified_date FROM `user` WHERE user_account = :account";
        Map<String , Object> map = new HashMap<>();

        map.put("account" , account);


        List<User> userList = namedParameterJdbcTemplate.query(sql ,new MapSqlParameterSource(map) , new UserRowMapper());

        if(userList.size()>0) return  userList.get(0);
        else return null ;
    }

    public User login(UserLoginRequest userLoginRequest){
        String sql = "SELECT user_id, user_account, user_password , created_date , last_modified_date FROM `user` WHERE user_account = :user_account AND user_password = :user_password";

        Map<String , Object> map = new HashMap<>();

        map.put("user_account", userLoginRequest.getUser_account());
        map.put("user_password" , userLoginRequest.getUser_password());


        List<User> userList= namedParameterJdbcTemplate.query(sql , new MapSqlParameterSource(map) , new UserRowMapper());


        if(userList.size()>0) return userList.get(0);
        else return null ;


    }

}

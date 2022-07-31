package com.kazama.springtodolistweb.RowMapper;

import com.kazama.springtodolistweb.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet , int rowNum) throws SQLException{

        User user = new User();

        user.setUser_id(resultSet.getInt("user_id"));
        user.setUser_account(resultSet.getString("user_account"));
        user.setUser_password(resultSet.getString("user_password"));
        user.setCreated_date(resultSet.getTimestamp("created_date"));
        user.setLast_modified_date(resultSet.getTimestamp("last_modified_date"));

        return user;
    }
}

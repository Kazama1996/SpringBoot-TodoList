package com.kazama.springtodolistweb.RowMapper;

import com.kazama.springtodolistweb.model.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task>{
    public Task mapRow(ResultSet resultSet , int rowNum) throws SQLException {

        Task task = new Task();
        task.setTask_id(resultSet.getInt("task_id"));
        task.setTask_name(resultSet.getString("task_name"));
        task.setCreated_date(resultSet.getTimestamp("created_date"));
        task.setList_id(resultSet.getInt("list_id"));
        task.setUser_id(resultSet.getInt("user_id"));
        task.setDeadline(resultSet.getTimestamp("deadLine"));
        return task ;
    }
}

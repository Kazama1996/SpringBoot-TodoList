package com.kazama.springtodolistweb.RowMapper;

import com.kazama.springtodolistweb.model.TaskList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskListRowMapper implements RowMapper<TaskList> {

    public TaskList mapRow(ResultSet resultSet , int rowNum) throws SQLException {
        TaskList taskList = new TaskList();
        taskList.setTaskList_id(resultSet.getInt("list_id"));
        taskList.setUser_id(resultSet.getInt("user_id"));
        taskList.setList_name(resultSet.getString("list_name"));
        taskList.setCreated_date(resultSet.getTimestamp("created_date"));
        taskList.setLast_modified_date(resultSet.getTimestamp("last_modified_date"));
        return taskList;
    }
}

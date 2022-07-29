package com.kazama.springtodolistweb.Dao.impl;

import com.kazama.springtodolistweb.Dao.TaskDao;
import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    public Integer addTask(TaskRequest taskRequest){

        String sql = "INSERT INTO task(task_name , created_date , deadline) VALUES (:task_name ,:created_date, :deadline)";

        Map<String, Object> map = new HashMap<>();

        map.put("task_name" ,taskRequest.getTaskName());
        map.put("deadline", new Date());
        map.put("created_date", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql , new MapSqlParameterSource(map) ,keyHolder);

        int key = keyHolder.getKey().intValue();

        return key ;
    }
}

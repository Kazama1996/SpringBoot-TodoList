package com.kazama.springtodolistweb.Dao.impl;

import com.kazama.springtodolistweb.Dao.TaskDao;
import com.kazama.springtodolistweb.Dao.TaskListDao;
import com.kazama.springtodolistweb.RowMapper.TaskListRowMapper;
import com.kazama.springtodolistweb.dto.TaskListRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskListRequest;
import com.kazama.springtodolistweb.model.TaskList;
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
public class TaskListDaoImpl implements TaskListDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer creatTaskList(Integer userId, TaskListRequest taskListRequest) {
        String sql = "INSERT INTO tasklist (user_id , list_name , created_date , last_modified_date) " +
                "VALUES(:user_id,:list_name,:created_date,:last_modified_date)";

        Map<String, Object> map= new HashMap<>();

        map.put("user_id" , userId);
        map.put("list_name" , taskListRequest.getTaskList_name());
        map.put("created_date", new Date());
        map.put("last_modified_date" , new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql ,new MapSqlParameterSource(map),keyHolder);

        int key = keyHolder.getKey().intValue();

        return key;

    }

    @Override
    public void renameList(Integer userId, UpdateTaskListRequest updateTaskListRequest) {

        String sql = "UPDATE tasklist SET list_name = :list_name ,last_modified_date = :last_modified_date WHERE list_id = :list_id AND user_id = :user_id";

        Map<String , Object> map = new HashMap<>();

        map.put("list_name" ,updateTaskListRequest.getUpdated_name());
        map.put("list_id" , updateTaskListRequest.getList_id());
        map.put("user_id" , userId);
        map.put("last_modified_date", new Date());
        namedParameterJdbcTemplate.update(sql ,map);

    }

    @Override
    public TaskList getListById(Integer listId) {
        String sql = "SELECT list_id,user_id,list_name,created_date,last_modified_date FROM tasklist WHERE list_id = :list_id";

        Map<String, Object> map = new HashMap<>();

        map.put("list_id" ,listId);

        List<TaskList> taskList =namedParameterJdbcTemplate.query(sql ,new MapSqlParameterSource(map) , new TaskListRowMapper());

        if(taskList.size()>0) return taskList.get(0);
        else return null;
    }

    @Override
    public void deleteList(Integer userId, Integer listId) {
        String sql = "DELETE FROM tasklist WHERE list_id =:list_id AND user_id = :user_id";


        Map<String,Object> map = new HashMap<>();


        map.put("user_id" ,userId);
        map.put("list_id",listId);

        namedParameterJdbcTemplate.update(sql ,map);

    }
}

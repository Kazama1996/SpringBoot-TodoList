package com.kazama.springtodolistweb.Dao.impl;

import com.kazama.springtodolistweb.Dao.TaskDao;
import com.kazama.springtodolistweb.RowMapper.TaskRowMapper;
import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskRequest;
import com.kazama.springtodolistweb.model.Task;
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
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer addTask(Integer userId ,Integer listId ,TaskRequest taskRequest){

        String sql = "INSERT INTO task(task_name , created_date , deadline ,user_id,list_id) VALUES (:task_name ,:created_date, :deadline , :user_id ,:list_id) ";

        Map<String, Object> map = new HashMap<>();

        map.put("task_name" ,taskRequest.getTaskName());
        map.put("deadline", new Date());
        map.put("created_date", new Date());
        map.put("user_id" , userId);
        map.put("list_id",listId);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql , new MapSqlParameterSource(map) ,keyHolder);

        int key = keyHolder.getKey().intValue();

        return key ;
    }

    public void deleteTask(Integer userId,Integer listId,Integer taskId){
        String sql = "DELETE FROM task  WHERE task_id =:taskId AND user_id =:userId AND list_id =:listId";

        Map<String,Object> map = new HashMap<>();

        map.put("taskId", taskId);
        map.put("userId", userId);
        map.put("listId", listId);


        namedParameterJdbcTemplate.update(sql,map);

    }

    @Override
    public Task getTaskById(Integer taskId) {
        String sql = "SELECT task_id , task_name,created_date,deadLine,user_id,list_id FROM task WHERE task_id = :task_id";
        Map<String ,Object> map  = new HashMap<>();

        map.put("task_id" ,taskId);

        List<Task> taskList = namedParameterJdbcTemplate.query(sql ,new MapSqlParameterSource(map) ,new TaskRowMapper());

        if(taskList.size()>0) return taskList.get(0);
        else return null;

    }

    @Override
    public void renameTask(Integer userId, Integer listId, UpdateTaskRequest updateTaskRequest){
        String sql = "UPDATE task SET task_name = :updateName WHERE user_id =:userId AND list_id =:listId AND task_id =:taskId";

        Map<String, Object> map = new HashMap<>();

        map.put("userId",userId);
        map.put("listId",listId);
        map.put("updateName",updateTaskRequest.getUpdateName());
        map.put("taskId" , updateTaskRequest.getTaskId());


        namedParameterJdbcTemplate.update(sql , map);

    }
}

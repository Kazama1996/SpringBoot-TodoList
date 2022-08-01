package com.kazama.springtodolistweb.Dao;


import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskRequest;
import com.kazama.springtodolistweb.model.Task;

public interface TaskDao {

    public Integer addTask(Integer userId, Integer listId, TaskRequest taskRequest);

    public void deleteTask( Integer userId , Integer listId , Integer taskId);

    public Task getTaskById(Integer taskId);

    public void renameTask(Integer userId, Integer listId, UpdateTaskRequest updateTaskRequest);
}

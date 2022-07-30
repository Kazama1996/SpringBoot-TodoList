package com.kazama.springtodolistweb.Dao;


import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.model.Task;

public interface TaskDao {

    public Integer addTask(TaskRequest taskRequest);

    public void deleteTaskById(Integer taskId);
}

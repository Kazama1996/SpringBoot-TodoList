package com.kazama.springtodolistweb.Service;


import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.model.Task;

public interface TaskService {

    public Integer  addTask(TaskRequest taskRequest);
}

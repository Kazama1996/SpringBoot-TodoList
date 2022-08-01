package com.kazama.springtodolistweb.Service;

import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskRequest;
import com.kazama.springtodolistweb.model.Task;

public interface TaskService {

    public Task createTask(Integer userId, Integer listId , TaskRequest taskRequest);

    public Task renameTask(Integer userId , Integer listId , UpdateTaskRequest updateTaskRequest);

    public void deleteTask(Integer userId , Integer listId, Integer taskId);
}

package com.kazama.springtodolistweb.Service;


import com.kazama.springtodolistweb.dto.TaskRequest;
import org.springframework.web.bind.annotation.PathVariable;

public interface TaskService {

    public Integer  addTask(TaskRequest taskRequest);

    public void deleteTaskById(@PathVariable Integer taskId);

}

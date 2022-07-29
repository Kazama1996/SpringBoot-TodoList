package com.kazama.springtodolistweb.Service.Impl;

import com.kazama.springtodolistweb.Dao.TaskDao;
import com.kazama.springtodolistweb.Service.TaskService;
import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    public Integer addTask(TaskRequest taskRequest){

        return taskDao.addTask(taskRequest);

    }
}

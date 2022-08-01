package com.kazama.springtodolistweb.Service.Impl;

import com.kazama.springtodolistweb.Dao.TaskDao;
import com.kazama.springtodolistweb.Dao.TaskListDao;
import com.kazama.springtodolistweb.Dao.UserDao;
import com.kazama.springtodolistweb.Service.TaskService;
import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskRequest;
import com.kazama.springtodolistweb.model.Task;
import com.kazama.springtodolistweb.model.TaskList;
import com.kazama.springtodolistweb.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class TaskServiceImpl implements TaskService {

    private final static Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private TaskListDao taskListDao;

    @Autowired
    private TaskDao taskDao;
    @Override
    public Task createTask(Integer userId, Integer listId, TaskRequest taskRequest) {

        User user = userDao.getUserById(userId);
        if(user==null){
            log.warn("User : {} is not found" , userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        TaskList taskList = taskListDao.getListById(listId);

        if(taskList==null){
            log.warn("TaskList : {} is not found" , listId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Integer taskId = taskDao.addTask(userId,listId,taskRequest);

        Task task = taskDao.getTaskById(taskId);

        return task;
    }

    @Override
    public Task renameTask(Integer userId, Integer listId, UpdateTaskRequest updateTaskRequest) {
        taskDao.renameTask(userId,listId,updateTaskRequest);

        Task task = taskDao.getTaskById(updateTaskRequest.getTaskId());

        if(task==null){
            log.warn("Task : {} is not found ! " , updateTaskRequest.getTaskId());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        else return task ;

    }

    @Override
    public void deleteTask(Integer userId, Integer listId, Integer taskId) {
       taskDao.deleteTask(userId ,  listId  ,taskId);
    }
}

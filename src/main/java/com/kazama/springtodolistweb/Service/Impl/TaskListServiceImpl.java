package com.kazama.springtodolistweb.Service.Impl;

import com.kazama.springtodolistweb.Dao.TaskListDao;
import com.kazama.springtodolistweb.Dao.UserDao;
import com.kazama.springtodolistweb.Service.TaskListService;
import com.kazama.springtodolistweb.dto.TaskListRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskListRequest;
import com.kazama.springtodolistweb.model.TaskList;
import com.kazama.springtodolistweb.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class TaskListServiceImpl implements TaskListService {


    private final static Logger log = LoggerFactory.getLogger(TaskListServiceImpl.class);
    @Autowired
    private TaskListDao taskListDao;

    @Autowired
    private UserDao userDao;

    public Integer createTaskList(Integer userId , TaskListRequest taskListRequest){

        User user = userDao.getUserById(userId);

        if(user==null){
            log.warn("user : {} is not found!!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return taskListDao.creatTaskList(userId , taskListRequest);
    }

    @Override
    public TaskList getListById(Integer listId) {

        return taskListDao.getListById(listId);
    }

    @Override
    public void renameList(Integer userId, UpdateTaskListRequest updateTaskListRequest) {

         taskListDao.renameList(userId,updateTaskListRequest);

    }

    @Override
    public void deleteList(Integer userId, Integer listId) {
        taskListDao.deleteList(userId ,listId);
    }
}

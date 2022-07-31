package com.kazama.springtodolistweb.Dao;

import com.kazama.springtodolistweb.dto.TaskListRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskListRequest;
import com.kazama.springtodolistweb.model.TaskList;

public interface TaskListDao {

    public Integer creatTaskList(Integer userId , TaskListRequest taskListRequest);


    public void renameList(Integer userId , UpdateTaskListRequest updateTaskListRequest);

    public TaskList getListById(Integer listId);

    public void deleteList(Integer userId, Integer listId);
}

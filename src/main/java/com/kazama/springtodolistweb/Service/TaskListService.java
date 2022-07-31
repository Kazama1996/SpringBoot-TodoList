package com.kazama.springtodolistweb.Service;

import com.kazama.springtodolistweb.dto.TaskListRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskListRequest;
import com.kazama.springtodolistweb.model.Task;
import com.kazama.springtodolistweb.model.TaskList;

public interface TaskListService {

    public Integer createTaskList(Integer userId, TaskListRequest taskListRequest);

    public TaskList getListById(Integer listId);

    public void renameList(Integer userId , UpdateTaskListRequest updateTaskListRequest);

    public void deleteList(Integer userId , Integer listId);


}

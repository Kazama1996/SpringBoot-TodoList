package com.kazama.springtodolistweb.Controller;

import com.kazama.springtodolistweb.Service.TaskListService;
import com.kazama.springtodolistweb.dto.TaskListRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskListRequest;
import com.kazama.springtodolistweb.model.TaskList;
import com.sun.source.util.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class taskListController {

    @Autowired
    private TaskListService taskListService;



    @PostMapping("users/{userId}/lists")
    public ResponseEntity<?> createTaskList(@PathVariable Integer userId,
                                                   @RequestBody TaskListRequest taskListRequest){

        Integer taskListId=taskListService.createTaskList(userId,taskListRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(taskListId);
    }

    @PutMapping("users/{userId}/lists")
    public  ResponseEntity<TaskList> renameList(@PathVariable Integer userId,
                       @RequestBody UpdateTaskListRequest updateTaskListRequest){

        TaskList taskList = taskListService.getListById(updateTaskListRequest.getList_id());

        if(taskList==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        taskListService.renameList(userId , updateTaskListRequest);

        TaskList updatedList = taskListService.getListById(updateTaskListRequest.getList_id());

        return ResponseEntity.status(HttpStatus.OK).body(updatedList);

    }

    @DeleteMapping("users/{userId}/lists/{listId}")
    public ResponseEntity<?> deleteList(@PathVariable  Integer userId,
                                        @PathVariable Integer listId){


        taskListService.deleteList(userId, listId);


        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }


}

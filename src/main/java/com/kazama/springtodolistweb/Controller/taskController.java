package com.kazama.springtodolistweb.Controller;

import com.kazama.springtodolistweb.Service.TaskService;
import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.dto.UpdateTaskRequest;
import com.kazama.springtodolistweb.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class taskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/users/{userId}/lists/{listId}")
    public ResponseEntity<Task> addTask(@PathVariable Integer  userId,
                                        @PathVariable  Integer listId,
                                        @RequestBody TaskRequest taskRequest){


        Task task = taskService.createTask(userId ,listId , taskRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);

    }
    @PutMapping("/users/{userId}/lists/{listId}")
    public ResponseEntity<Task> renameTask(@PathVariable Integer userId,
                                           @PathVariable Integer listId,
                                           @RequestBody UpdateTaskRequest updateTaskRequest){

        Task task = taskService.renameTask(userId, listId,updateTaskRequest);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(task);
    }

    @DeleteMapping("users/{userId}/lists/{listId}/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer userId,
                                        @PathVariable Integer listId,
                                        @PathVariable Integer taskId){

        taskService.deleteTask(userId,listId,taskId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

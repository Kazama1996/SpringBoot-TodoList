package com.kazama.springtodolistweb.Controller;


import com.kazama.springtodolistweb.Service.TaskService;
import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class taskController {

    @Autowired
    private TaskService taskService ;

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer taskId){

        taskService.deleteTaskById(taskId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/tasks")
    public Integer addTask(@RequestBody TaskRequest taskRequest){
        return taskService.addTask(taskRequest);
    }




}

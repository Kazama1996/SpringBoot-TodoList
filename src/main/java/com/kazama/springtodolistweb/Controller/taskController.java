package com.kazama.springtodolistweb.Controller;


import com.kazama.springtodolistweb.Service.TaskService;
import com.kazama.springtodolistweb.dto.TaskRequest;
import com.kazama.springtodolistweb.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class taskController {

    @Autowired
    private TaskService taskService ;

    @PostMapping("/tasks")
    public Integer addTask(@RequestBody TaskRequest taskRequest){


        return taskService.addTask(taskRequest);



    }


}

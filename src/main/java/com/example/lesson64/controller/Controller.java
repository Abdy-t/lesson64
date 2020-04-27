package com.example.lesson64.controller;

import com.example.lesson64.model.Task;
import com.example.lesson64.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final TaskService taskService;

    public Controller(TaskService taskService) {
        this.taskService=taskService;
    }

    @GetMapping("/getTasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping("/status")
    public void changeStatus(@RequestParam("id") String id) {
        System.out.println("ID task - " + id);
        taskService.changeStatus(id);
    }
}

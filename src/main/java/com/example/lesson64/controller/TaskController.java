package com.example.lesson64.controller;

import com.example.lesson64.service.TaskService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;

@org.springframework.stereotype.Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService=taskService;
    }
    @GetMapping
    public String demo(Model model) {
        return "taskList";
    }
    @RequestMapping(value = "/task", method = RequestMethod.POST, consumes=MULTIPART_FORM_DATA)
    public String taskAdd(@RequestParam("title") String title) {
        System.out.println("Text : " + title);
        taskService.saveNewTask(title);
        return "success";
    }
}

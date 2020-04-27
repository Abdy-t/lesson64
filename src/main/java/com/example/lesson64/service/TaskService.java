package com.example.lesson64.service;

import com.example.lesson64.model.Task;
import com.example.lesson64.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository=taskRepository;
    }

    public void saveNewTask(String title) {
        Task task = Task.builder()
                .title(title)
                .status(true)
                .build();
        taskRepository.save(task);
    }

    public List<Task> getTasks() {
        var a = taskRepository.findAll();
        List<Task> publications = StreamSupport.stream(a.spliterator(), false)
                .collect(Collectors.toList());
        return publications;
    }

    public void changeStatus(String id) {
        var t = taskRepository.findTaskById(id);
        if (t.isStatus()){
           t.setStatus(false);
        } else t.setStatus(true);
        taskRepository.save(t);
    }
}

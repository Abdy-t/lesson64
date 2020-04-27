package com.example.lesson64.repository;

import com.example.lesson64.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository  extends CrudRepository<Task, String> {
    Task findTaskById(String id);
}

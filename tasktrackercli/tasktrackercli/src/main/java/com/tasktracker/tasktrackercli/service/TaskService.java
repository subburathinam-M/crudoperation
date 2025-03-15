package com.tasktracker.tasktrackercli.service;

import java.util.List;

import com.tasktracker.tasktrackercli.entiy.Task;

public interface TaskService {
    Task addTask(String description);
    Task updateTask(String id, String description);
    void deleteTask(String id);
    Task markTaskStatus(String id, String status);
    List<Task> listTasks(String status);
   
}

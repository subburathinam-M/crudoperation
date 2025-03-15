package com.tasktracker.tasktrackercli.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tasktracker.tasktrackercli.entiy.Task;
import com.tasktracker.tasktrackercli.repository.TaskRepository;
import com.tasktracker.tasktrackercli.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTask(String description) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus("todo");
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(String id, String description){
       Optional<Task> task = taskRepository.findById(id);
       if(task.isPresent()){
        Task task1 = task.get();
        task1.setDescription(description);
        task1.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task1);
       }
       throw new RuntimeException("Task not found");
    }

    @Override
    public void deleteTask(String id){
        // taskRepository.deleteById(id);
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found or already deleted");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public Task markTaskStatus(String id, String status){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            Task task1 = task.get();
            task1.setStatus(status);
            task1.setUpdatedAt(LocalDateTime.now());
            return taskRepository.save(task1);
            }
            throw new RuntimeException("Task not found");
        }

        @Override
        public List<Task> listTasks(String status){
            // if(status != null){
            //     return taskRepository.findByStatus(status);
            // }
            // return taskRepository.findAll();
            List<Task> tasks;
            if (status != null && !status.isEmpty()) {
                tasks = taskRepository.findByStatus(status);
            } else {
                tasks = taskRepository.findAll();
            }
            
            if (tasks.isEmpty()) {
                throw new RuntimeException("No tasks found");
            }
            return tasks;
        }
}

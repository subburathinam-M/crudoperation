package com.tasktracker.tasktrackercli.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasktracker.tasktrackercli.entiy.Task;
import com.tasktracker.tasktrackercli.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/add")
    public Task addTask(@RequestParam String description) {
        return taskService.addTask(description);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable String id, @RequestParam String description ){
        return taskService.updateTask(id, description);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }

    @PatchMapping("/status/{id}")
    public Task markTaskStatus(@PathVariable String id, @RequestParam String status) {
        return taskService.markTaskStatus(id, status);
    }

    @GetMapping("/list")
    public List<Task> listTasks(@RequestParam(required = false) String status) {
        return taskService.listTasks(status);
    }

}

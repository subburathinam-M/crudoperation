package com.tasktracker.tasktrackercli.cli;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import com.tasktracker.tasktrackercli.entiy.Task;
import com.tasktracker.tasktrackercli.service.TaskService;


import java.util.List;


@ShellComponent
public class TaskCliCommands {

    private final TaskService taskService;;

    public TaskCliCommands(TaskService taskService) {
        this.taskService = taskService;
    }

   @ShellMethod(key = "add", value = "Add a new task")
    public String addTask(@ShellOption String description) {
        Task task = taskService.addTask(description);
        return "Task added successfully (ID: " + task.getId() + ")";
    }

    @ShellMethod(key = "update", value = "Update task description")
    public String updateTask(@ShellOption String id, @ShellOption String description) {
        Task task = taskService.updateTask(id, description);
        return "Task updated: " + task.getDescription();
    }

    @ShellMethod(key = "delete", value = "Delete a task by ID")
    public String deleteTask(@ShellOption String id) {
        taskService.deleteTask(id);
        return "Task deleted successfully!";
    }

    @ShellMethod(key = "status", value = "Update task status")
    public String markTaskStatus(@ShellOption String id, @ShellOption String status) {
        Task task = taskService.markTaskStatus(id, status);
        return "Task status updated to: " + task.getStatus();
    }

    @ShellMethod(key = "list", value = "List all tasks or filter by status")
    public String listTasks(@ShellOption(defaultValue = "") String status) {
        List<Task> tasks = taskService.listTasks(status);
        if (tasks.isEmpty()) {
            return "No tasks found.";
        }
        StringBuilder result = new StringBuilder("Tasks:\n");
        tasks.forEach(task -> result.append(task.getId()).append(": ").append(task.getDescription()).append(" (").append(task.getStatus()).append(")\n"));
        return result.toString();
    }



}

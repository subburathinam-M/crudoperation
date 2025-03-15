package com.tasktracker.tasktrackercli.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasktracker.tasktrackercli.entiy.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByStatus(String status); 

}

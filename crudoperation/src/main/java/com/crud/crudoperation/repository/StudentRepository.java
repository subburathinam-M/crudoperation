package com.crud.crudoperation.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.crudoperation.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findByEmail(String email);
    Optional<Student> findByStudentId(String studentId);
}

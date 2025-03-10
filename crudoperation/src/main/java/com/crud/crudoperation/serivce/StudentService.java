package com.crud.crudoperation.serivce;

import java.util.List;

import com.crud.crudoperation.entity.Student;
import com.crud.crudoperation.response.ApiResponse;

public interface StudentService {

    ApiResponse createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(String studentId);
    ApiResponse updateStudent(String studentId, Student student);
    String deleteStudent(String studentId);

}

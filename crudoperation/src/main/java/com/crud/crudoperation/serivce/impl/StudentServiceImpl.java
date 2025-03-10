package com.crud.crudoperation.serivce.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.crudoperation.entity.Student;
import com.crud.crudoperation.exception.StudentNotFoundException;
import com.crud.crudoperation.repository.StudentRepository;
import com.crud.crudoperation.response.ApiResponse;
import com.crud.crudoperation.serivce.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
     public ApiResponse createStudent(Student student) {
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            return new ApiResponse("Email already exists", null);
        }
        if(studentRepository.findByStudentId(student.getStudentId()).isPresent()){
            return new ApiResponse("Student Id already exists", null);
        }
            Student createStudent = studentRepository.save(student);
              return new ApiResponse("Student created successfully", createStudent); 
}


    @Override 
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    @Override
    public ApiResponse updateStudent(String id, Student student) {
        Student studentToupdate = studentRepository.findById(id)
        .orElseThrow(() -> new StudentNotFoundException("Student not found"));
        studentToupdate.setStudentName(student.getStudentName());
        studentToupdate.setEmail(student.getEmail());
        studentToupdate.setAge(student.getAge());
        studentToupdate.setGrade(student.getGrade());
        studentToupdate.setCourses(student.getCourses());
        studentRepository.save(studentToupdate);
        return new ApiResponse("Student updated successfully", studentToupdate);
    }

    @Override
    public String deleteStudent(String studentId){
        studentRepository.deleteById(studentId);
        return "Student deleted successfully";
    }

     
}

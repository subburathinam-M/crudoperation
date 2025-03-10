package com.crud.crudoperation.controllor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudoperation.entity.Student;
import com.crud.crudoperation.response.ApiResponse;
import com.crud.crudoperation.serivce.StudentService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

     @PostMapping("/create")
     public ApiResponse createStudent(@RequestBody Student student) {
         return studentService.createStudent(student);
     }


     @GetMapping("/all")
     public List<Student> getAllStudents() {
            return studentService.getAllStudents();
     }

     @GetMapping("/{id}")
     public Student getStudentById(@PathVariable String id) {
         return studentService.getStudentById(id);
     }

        @PutMapping("/update/{id}")
        public ApiResponse updateStudent(@PathVariable String id, @RequestBody Student student) {
            return studentService.updateStudent(id, student);
        }

        @DeleteMapping("/delete/{id}")
        public String deleteStudent(@PathVariable String id) {
            return studentService.deleteStudent(id);
        }

}

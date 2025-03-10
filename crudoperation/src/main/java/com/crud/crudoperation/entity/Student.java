package com.crud.crudoperation.entity;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Student")
public class Student {

    @Id
    private String id;
    private String studentId;
    private String studentName;
    private String email;
    private int age;
    private String grade;
    private List<String> courses;

}

package com.naresh.examresult.service;

import com.naresh.examresult.entity.Student;
import com.naresh.examresult.entity.StudentResult;

import java.util.List;


public interface StudentService {

    String loginStudent(String rollNo,String password);
    Student createStudent(Student student);
    Student getStudentById(String rollNo);
    StudentResult getResult(String rollNo, String password);
    List<Student>getAllStudents();
    Student updateStudent(Student student);
    void deleteStudent(String rollNo);
}

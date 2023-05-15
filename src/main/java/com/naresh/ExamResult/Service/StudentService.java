package com.naresh.ExamResult.Service;

import com.naresh.ExamResult.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    String loginStudent(String rollNo,String password);
    Student createStudent(Student student);
    Student getStudentById(String rollNo);
    List<Student>getAllStudents();
    Student updateStudent(Student student);
    void deleteStudent(String rollNo);
}

package com.naresh.ExamResult.Controller;

import com.naresh.ExamResult.Entity.Student;
import com.naresh.ExamResult.Service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/student")
public class StudentController {
private StudentService studentService;

@PostMapping
public ResponseEntity<Student> createStudent(@RequestBody Student student){
Student savedStudent =studentService.createStudent(student);
return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
}
}

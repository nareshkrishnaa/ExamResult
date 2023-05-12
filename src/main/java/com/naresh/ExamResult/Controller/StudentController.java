package com.naresh.ExamResult.Controller;

import com.naresh.ExamResult.Entity.Student;
import com.naresh.ExamResult.Service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
private StudentService studentService;

@PostMapping
public ResponseEntity<Student> createStudent(@RequestBody Student student){
Student savedStudent =studentService.createStudent(student);
return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
}

@GetMapping("{rollNo}")
    public ResponseEntity<Student> getStudent(@PathVariable("rollNo") String rollNumber){

    Student student = studentService.getStudentById(rollNumber);
    return new ResponseEntity<>(student,HttpStatus.OK);

    }

   @GetMapping("all")
   public ResponseEntity<List<Student>> getAllStudents(){
       List<Student> list = studentService.getAllStudents();
       return new ResponseEntity<>(list,HttpStatus.OK);
   }


   @PutMapping({"rollNo"})
    public ResponseEntity<Student> updateStudent(@PathVariable("rollNo") String rollNo,@RequestBody Student student){
    Student updatedStudent = studentService.updateStudent(student);
    return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
   }

   @DeleteMapping("{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable("rollNo") String rollNo){
        studentService.deleteStudent(rollNo);
        return new ResponseEntity<>("User deleted",HttpStatus.OK);
   }
}

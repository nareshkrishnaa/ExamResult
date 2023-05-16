package com.naresh.ExamResult.controller;

import com.naresh.ExamResult.entity.Student;
import com.naresh.ExamResult.entity.StudentResult;
import com.naresh.ExamResult.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
private StudentService studentService;

@PostMapping("/create")
public ResponseEntity<String> createStudent(@RequestBody Student student){
    System.out.println("1");
    Student createdStudent=studentService.createStudent(student);
    String s1="Student created for "+createdStudent.getName()+
            "! rollNo = "+createdStudent.getRollNo()+" and Password = "+createdStudent.getPassword();
    System.out.println(s1);
    return ResponseEntity.ok(s1);
}

    @GetMapping("/get-result/{id}/{pwd}")
    public ResponseEntity<StudentResult> getStudentResult(@PathVariable("id") String id, @PathVariable("pwd") String password){
        return ResponseEntity.ok(studentService.getResult(id,password));

    }

@GetMapping("/login/{id}/{pwd}")
public ResponseEntity<String> loginStudent(@PathVariable("id") String id,@PathVariable("pwd") String password){
    return ResponseEntity.ok(studentService.loginStudent(id,password));

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

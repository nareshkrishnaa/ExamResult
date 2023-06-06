/* (C)2023 */
package com.naresh.examresult.controller;

import com.naresh.examresult.entity.Student;
import com.naresh.examresult.entity.StudentDto;
import com.naresh.examresult.service.StudentService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @PostMapping("/create") // RBAuth done
    public ResponseEntity<StudentDto> createStudent(@RequestBody Student student) {

        StudentDto createdStudentDto = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudentDto);
    }

    @GetMapping("/get-result/{id}/{pwd}") // RBAuth done
    public ResponseEntity<StudentDto> getStudentResult(
            @PathVariable("id") Integer id, @PathVariable("pwd") String password) {
        StudentDto studentDto = studentService.getResult(id, password);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping("/login/{id}/{pwd}") // RBAuth done
    public ResponseEntity<StudentDto> loginStudent(
            @PathVariable("id") Integer id, @PathVariable("pwd") String password) {
        return ResponseEntity.ok(studentService.loginStudent(id, password));
    }
    //
    //    @GetMapping("/get-student/{rollNo1}") // RBAUth done
    //    public ResponseEntity<Student> getStudent(@PathVariable("rollNo1") String rollNumber) {
    //
    //        Student student = studentService.getStudentById(rollNumber);
    //        return new ResponseEntity<>(student, HttpStatus.OK);
    //    }
    //
    //    @GetMapping("all") // RBAuth done
    //    public ResponseEntity<List<Student>> getAllStudents() {
    //        List<Student> list = studentService.getAllStudents();
    //        return new ResponseEntity<>(list, HttpStatus.OK);
    //    }
    //
    //    @PutMapping("/update/{rollNo1}") // RBAuth done
    //    public ResponseEntity<Student> updateStudent(
    //            @PathVariable("rollNo1") String rollNo, @RequestBody Student student) {
    //        Student updatedStudent = studentService.updateStudent(student);
    //        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    //    }
    //
    //    @DeleteMapping("/delete/{rollNo1}") // RBAuth done
    //    public ResponseEntity<String> deleteStudent(@PathVariable("rollNo1") String rollNo) {
    //        studentService.deleteStudent(rollNo);
    //        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    //    }
}

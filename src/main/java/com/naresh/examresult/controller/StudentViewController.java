/* (C)2023 */
package com.naresh.examresult.controller;

import com.naresh.examresult.entity.PasswordChecker;
import com.naresh.examresult.entity.Student;
import com.naresh.examresult.entity.StudentDto;
import com.naresh.examresult.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentViewController {

    @Autowired private StudentService studentService;

    // http://localhost:8080/list
    @GetMapping("/list")
    public String getStudentList(Model model) {
        System.out.println("redirected to this method");
        List<StudentDto> studentDtos = studentService.getAllStudents();
        model.addAttribute("students", studentDtos);
        return "student-list";
    }
    //http://localhost:8080/dummy2
    @GetMapping("/dummy2")
    public String getStudentListdummy2(Model model) {
        System.out.println("redirected to this method");
        List<StudentDto> studentDtos = studentService.getAllStudents();
        model.addAttribute("students", studentDtos);
        return "dummy2";
    }

        // http://localhost:8080/new-student
    @GetMapping("new-student")
    public String newStudent(Model model) {
        // student model object to store student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create-student";
    }

    @PostMapping("/student/created")
    public String savedSuccess(Model model, @ModelAttribute("student") Student student) {
        StudentDto studentDto = studentService.createStudent(student);
        Integer rollNo = studentDto.getRollNo();
        model.addAttribute("rollNo", rollNo);
        return "student-created";
    }

    //http://localhost:8080/get-result
    @GetMapping("/get-result")
    public String getResultPage(Model model) {
        PasswordChecker passwordChecker = new PasswordChecker();
        model.addAttribute("passwordChecker", passwordChecker);
        return "get-result-page";
    }

    @PostMapping("display-result")
    public String displayResult(Model model,
                                @ModelAttribute("passwordChecker") PasswordChecker passwordChecker){
        System.out.println("rollNo : "+passwordChecker.getRollNo());
        System.out.println("password : "+passwordChecker.getPassword());
        StudentDto studentDto=studentService.getResult(passwordChecker.getRollNo(), passwordChecker.getPassword());
        model.addAttribute("studentDto",studentDto);
        return "display-result-page";
    }

    //http://localhost:8080/update-student
    @GetMapping("/update-student")
    public String updateStudent(Model model,@ModelAttribute("student") StudentDto studentDto){

        model.addAttribute("studentDto",studentDto);
        return "result-updation";
    }


    @PostMapping("/post-updation")
    public String postUpdation(Model model, @ModelAttribute("studentDto") StudentDto studentDto){
        StudentDto updatedStudentDto = new StudentDto();
        System.out.println(studentDto.getRollNo());
        System.out.println(studentDto.getName());
        System.out.println(studentDto.getMath());
        Optional<StudentDto> existingStudentDto =
                Optional.ofNullable(studentService.getStudentById(studentDto.getRollNo()));
        if(existingStudentDto.isPresent()){
            existingStudentDto.get().setName(studentDto.getName());
            existingStudentDto.get().setMath(studentDto.getMath());
            existingStudentDto.get().setEnglish(studentDto.getEnglish());
            existingStudentDto.get().setScience(studentDto.getScience());
             updatedStudentDto=studentService.updateStudent(studentDto);
            model.addAttribute("updatedDto",updatedStudentDto);
        }
        return "post-updation";

    }


    }



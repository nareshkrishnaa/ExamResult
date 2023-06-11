/* (C)2023 */
package com.naresh.examresult.controller;

import com.naresh.examresult.entity.Student;
import com.naresh.examresult.entity.StudentDto;
import com.naresh.examresult.service.StudentService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentViewController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String getStudentList(Model model){
        List<StudentDto> studentDtos = studentService.getAllStudents();
        model.addAttribute("students",studentDtos);
        return "student-list";
    }


}

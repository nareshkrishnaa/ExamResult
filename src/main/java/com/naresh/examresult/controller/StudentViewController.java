/* (C)2023 */
package com.naresh.examresult.controller;

import com.naresh.examresult.entity.Student;

import com.naresh.examresult.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentViewController {

    private StudentService studentService;
    @PostMapping("/view/post_student")
    public String createStudent(@RequestBody Student student, Model model) {

        model.addAttribute("student", student);

        return "student-create";
    }

    @GetMapping("/view/results")
    public String getAllStudents(Model model){


        List<Student> students = studentService.getAllStudents();

        model.addAttribute("students",students);
        return "result-page";
    }
}

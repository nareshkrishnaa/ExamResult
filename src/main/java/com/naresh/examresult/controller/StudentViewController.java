/* (C)2023 */
package com.naresh.examresult.controller;

import com.naresh.examresult.entity.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentViewController {

    @PostMapping("/view/post_student")
    public String createStudent(@RequestBody Student student, Model model) {

        model.addAttribute("student", student);

        return "student-create";
    }
}

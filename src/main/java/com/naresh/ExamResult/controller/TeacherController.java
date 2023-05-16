package com.naresh.ExamResult.controller;

import com.naresh.ExamResult.entity.Teacher;
import com.naresh.ExamResult.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

private TeacherService teacherService;


@PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
    return ResponseEntity.ok(teacherService.createTeacher(teacher));
}

@GetMapping("/login/{id}/{pwd}")
    public ResponseEntity<String> teacherLogin(@PathVariable("id") String id,@PathVariable("pwd") String password){
    return ResponseEntity.ok(teacherService.teacherLogin(id,password));
}

}

package com.naresh.examresult.controller;

import com.naresh.examresult.entity.Teacher;
import com.naresh.examresult.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

private TeacherService teacherService;


@PostMapping("/create") //RBAuth done
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
    return ResponseEntity.ok(teacherService.createTeacher(teacher));
}

@GetMapping("/login/{id}/{pwd}")//RBAuth done
    public ResponseEntity<String> teacherLogin(@PathVariable("id") String id,@PathVariable("pwd") String password){
    return ResponseEntity.ok(teacherService.teacherLogin(id,password));
}

}

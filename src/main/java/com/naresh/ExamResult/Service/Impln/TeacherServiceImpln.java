package com.naresh.ExamResult.Service.Impln;

import com.naresh.ExamResult.Entity.Teacher;
import com.naresh.ExamResult.Repository.TeacherRepository;
import com.naresh.ExamResult.Service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpln implements TeacherService {
    private TeacherRepository teacherRepository;


    @Override
    public String teacherLogin(String id, String password) {
        if(teacherRepository.findById(id).isPresent()){
            Teacher teacher = teacherRepository.findById(id).get();
            String s1 = teacher.getPassword();
            String s2 = password;
            if(s1.equals(s2)){
                return "Login successful";
            }
            else {
                return "Login failed";
            }
        }else
            return "login failed";
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}

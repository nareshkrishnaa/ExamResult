/* (C)2023 */
package com.naresh.examresult.service.Impln;

import com.naresh.examresult.entity.Teacher;
import com.naresh.examresult.repository.TeacherRepository;
import com.naresh.examresult.service.TeacherService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpln implements TeacherService {
    private TeacherRepository teacherRepository;

    @Override
    public String teacherLogin(Integer id, String password) {
        return null;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
       Teacher savedTeacher = teacherRepository.save(teacher);
        return savedTeacher;
    }
}

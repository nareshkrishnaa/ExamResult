package com.naresh.ExamResult.service;

import com.naresh.ExamResult.entity.Teacher;

public interface TeacherService {
    String teacherLogin(String id,String password);
    Teacher createTeacher(Teacher teacher);
    //String assignTeacher(String id,String );

}

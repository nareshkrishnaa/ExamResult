package com.naresh.examresult.service;

import com.naresh.examresult.entity.Teacher;

public interface TeacherService {
    String teacherLogin(String id,String password);
    Teacher createTeacher(Teacher teacher);
    //String assignTeacher(String id,String );

}

package com.naresh.ExamResult.Service;

import com.naresh.ExamResult.Entity.Teacher;

public interface TeacherService {
    String teacherLogin(String id,String password);
    Teacher createTeacher(Teacher teacher);

}

/* (C)2023 */
package com.naresh.examresult.service;

import com.naresh.examresult.entity.Teacher;

public interface TeacherService {
    String teacherLogin(Integer id, String password);

    Teacher createTeacher(Teacher teacher);
    // String assignTeacher(String id,String );

}

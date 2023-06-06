/* (C)2023 */
package com.naresh.examresult.service;

import com.naresh.examresult.entity.Student;
import com.naresh.examresult.entity.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto loginStudent(Integer rollNo, String password);

    StudentDto createStudent(Student student);

    StudentDto getStudentById(Integer rollNo);

    StudentDto getResult(Integer rollNo, String password);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Student student);

    void deleteStudent(Integer rollNo);
}

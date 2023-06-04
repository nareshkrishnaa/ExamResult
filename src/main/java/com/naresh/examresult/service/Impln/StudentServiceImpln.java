/* (C)2023 */
package com.naresh.examresult.service.Impln;

import com.naresh.examresult.entity.Student;
import com.naresh.examresult.entity.StudentDto;
import com.naresh.examresult.repository.StudentRepository;
import com.naresh.examresult.service.StudentService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpln implements StudentService {
    @Autowired private StudentRepository studentRepository;

    @Override
    public StudentDto loginStudent(Integer rollNo, String password) {
        Optional<Student> student = studentRepository.findById(rollNo);

        if (student.isPresent() && student.get().getPassword().equals(password))
            return new ModelMapper().map(student, StudentDto.class);
        else return new StudentDto();
    }

    @Override
    public StudentDto createStudent(Student student) {

        Student savedStudent = studentRepository.save(student);

        return new ModelMapper().map(savedStudent, StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(Integer rollNo) {
        Optional<Student> student = studentRepository.findById(rollNo);
        if (student.isPresent()) {
            return new ModelMapper().map(student, StudentDto.class);
        } else {
            return new StudentDto();
        }
    }

    @Override
    public StudentDto getResult(Integer rollNo, String password) {
        Optional<Student> student = studentRepository.findById(rollNo);

        if (student.isPresent() && student.get().getPassword().equals(password)) {
            return new ModelMapper().map(student, StudentDto.class);
        }
        return new StudentDto();
    }

    @Override
    public List<StudentDto> getAllStudents() {
        Optional<List<Student>> studentList = Optional.of(studentRepository.findAll());
        if (studentList.isPresent()) {
            List<StudentDto> studentDtoList = new ArrayList<>();
            for (Student student:
                 studentList.get()) {
                studentDtoList.add(new ModelMapper().map(student,StudentDto.class));
            }
            return studentDtoList;
        }

        StudentDto studentDto= new StudentDto();
        studentDto.setName("dummmy");
        List<StudentDto> studentDtos=new ArrayList<>();
        studentDtos.add(studentDto);
        return studentDtos;
    }

    @Override
    public StudentDto updateStudent(Student student) {
        Optional<Student> student1= studentRepository.findById(student.getRollNo());
        if(student1.isPresent()){
            Student updatedStudent=new Student();
            new ModelMapper().map(student,updatedStudent);
            studentRepository.save(updatedStudent);
            return new ModelMapper().map(updatedStudent,StudentDto.class);
        }

        return new StudentDto();
    }

    @Override
    public void deleteStudent(Integer rollNo) {

        Optional<Student> student= studentRepository.findById(rollNo);
        if(student.isPresent())
        studentRepository.delete(student.get());
    }
}

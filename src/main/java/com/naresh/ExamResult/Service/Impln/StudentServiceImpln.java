package com.naresh.ExamResult.Service.Impln;

import com.naresh.ExamResult.Entity.Student;
import com.naresh.ExamResult.Repository.StudentRepository;
import com.naresh.ExamResult.Service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpln implements StudentService {
    private StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String rollNo) {
        Optional<Student> optionalStudent=studentRepository.findById(rollNo);
        return optionalStudent.get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent =studentRepository.findById(student.getRollNo()).get();
        existingStudent.setName(student.getName());
        existingStudent.setPassword(student.getPassword());
        existingStudent.setSubject1(student.getSubject1());
        existingStudent.setSubject2(student.getSubject2());
        existingStudent.setSubject3(student.getSubject3());
        Student updatedStudent =studentRepository.save(existingStudent);
        return updatedStudent;
    }

    @Override
    public void deleteStudent(String rollNo) {
        studentRepository.deleteById(rollNo);
    }
}

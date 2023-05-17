package com.naresh.examresult.service.Impln;

import com.naresh.examresult.entity.Student;
import com.naresh.examresult.entity.StudentResult;
import com.naresh.examresult.exceptions.PasswordNotMatchingException;
import com.naresh.examresult.exceptions.ResourceNotFoundException;
import com.naresh.examresult.repository.StudentRepository;
import com.naresh.examresult.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.naresh.examresult.ExamResultApplication.modelMapper;

@Service
@AllArgsConstructor
public class StudentServiceImpln implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public String loginStudent(String rollNo, String password) {
        var  student =studentRepository.findById(rollNo);
        if(student.isPresent()){
            System.out.println("1");

            String s1=student.get().getPassword();
            if (s1.equals(password))
            {
                return "Login successful";
            }
            else {
                System.out.println("2");
                return "Login failure";
            }
        }
        else{
            return "Login failure";
        }


    }

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
    public StudentResult getResult(String rollNo, String password) {

        if(studentRepository.findById(rollNo).isPresent()){
        Student student = studentRepository.findById(rollNo).get();
        if(student.getPassword().equals(password)) {
            return modelMapper().map(student, StudentResult.class);
        }
        else {
            throw new PasswordNotMatchingException("Password wrong");
        }
        }
        else {
                throw new ResourceNotFoundException("No such item exists");
        }

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
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(String rollNo) {
        studentRepository.deleteById(rollNo);
    }
}

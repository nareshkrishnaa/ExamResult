/* (C)2023 */
package com.naresh.examresult.service.Impln;

import static org.junit.jupiter.api.Assertions.*;

import com.naresh.examresult.entity.Student;
import com.naresh.examresult.entity.StudentDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentServiceImplnTest {

    @Autowired StudentServiceImpln studentServiceImpln;

    @Test
    void loginStudentWithAValidEntry() {

        System.out.println("-----------------------------------------");

        var loggedInStudent = studentServiceImpln.loginStudent(2, "pwd");

        System.out.println(loggedInStudent.toString());

        System.out.println("-----------------------------------------");
    }

    @Test
    void loginStudentWithAnInvalidEntry() {

        System.out.println("-----------------------------------------");

        var loggedInStudent = studentServiceImpln.loginStudent(5, "pwd");

        System.out.println(loggedInStudent.toString());

        System.out.println("-----------------------------------------");
    }

    @Test
    void createStudent() {
        System.out.println("-----------------------------------------");
        Student student = new Student();
        student.setName("Rammi");
        student.setPassword("pwd1");
        student.setMath(45);
        student.setScience(55);
        student.setEnglish(65);
        StudentDto savedStudentDto = studentServiceImpln.createStudent(student);
        System.out.println(savedStudentDto.toString());
        System.out.println("-----------------------------------------");
    }

    @Test
    void getStudentByIdWithAValidEntry() {
        System.out.println("-----------------------------------------");
        Integer rollNo = 1;
        System.out.println(studentServiceImpln.getStudentById(rollNo).toString());
        System.out.println("-----------------------------------------");
    }

    @Test
    void getStudentByIdWithAnInvalidEntry() {
        System.out.println("-----------------------------------------");
        Integer rollNo = 7;
        System.out.println(studentServiceImpln.getStudentById(rollNo).toString());
        System.out.println("-----------------------------------------");
    }

    @Test
    void getResultOfAValidInput() {
        System.out.println("-----------------------------------------");
        Integer rollNo = 1;
        String password = "pwd";

        System.out.println(studentServiceImpln.getResult(rollNo, password));
        System.out.println("-----------------------------------------");
    }

    @Test
    void getResultOfAnInvalidInput() {
        System.out.println("-----------------------------------------");
        System.out.println("Wrong password");
        Integer rollNo = 1;
        String password = "#pwd";

        System.out.println(studentServiceImpln.getResult(rollNo, password));

        rollNo = 100;
        password = "pwd";
        System.out.println("-----------------------------------------");
        System.out.println("Wrong roll No");
        System.out.println(studentServiceImpln.getResult(rollNo, password));
        System.out.println("-----------------------------------------");
    }

    @Test
    void getListOfStudents() {
        System.out.println("-----------------------------------------------------------------");

        List<StudentDto> studentDtoList = studentServiceImpln.getAllStudents();
        for (StudentDto studentDto : studentDtoList) {
            System.out.println(studentDto);
        }

        System.out.println("--------------------------------------------------------------");
    }

    @Test
    void updateAnExistingStudent(){
        System.out.println("-----------------------------------------");
        Student student= new Student(2,"Bommi",25,30,35,"pwd");
        StudentDto studentDto= studentServiceImpln.updateStudent(student);
        System.out.println(studentDto);
        System.out.println("-----------------------------------------");
    }

    @Test
    void updateANonExistingStudent(){
        System.out.println("-----------------------------------------");
        Student student= new Student(2000,"Bommi",25,30,35,"pwd");
        StudentDto studentDto= studentServiceImpln.updateStudent(student);
        System.out.println(studentDto);
        System.out.println("-----------------------------------------");
    }

    @Test
    void deleteStudent(){
        System.out.println("------------------------------------------------");
        Integer rollNo=3;
        studentServiceImpln.deleteStudent(rollNo);
        System.out.println("------------------------------------------------");
    }
}

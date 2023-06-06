/* (C)2023 */
package com.naresh.examresult.service.Impln;

import static org.junit.jupiter.api.Assertions.*;

import com.naresh.examresult.entity.Student;
import com.naresh.examresult.entity.StudentDto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "spring.config.additional-location=classpath:application-test.properties")
class StudentServiceImplnTest {

    @Autowired StudentServiceImpln studentServiceImpln;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @BeforeEach
    void clearDataBase(){
        jdbcTemplate.execute("delete from student_table");
        //before each testcase this method will run
        //we're going to clear database before running each testcase
    }
    @Test
    void loginStudentWithAValidEntry() {

        System.out.println("-----------------------------------------");

        Student student = new Student();
        student.setName("Bommi");
        student.setPassword("pwd1");
        student.setMath(45);
        student.setScience(55);
        student.setEnglish(65);
        StudentDto savedStudentDto = studentServiceImpln.createStudent(student);
        StudentDto loggedInStudent = studentServiceImpln.loginStudent(savedStudentDto.getRollNo(), "pwd1");

        System.out.println(loggedInStudent.toString());
        Assertions.assertEquals(savedStudentDto.getRollNo(),loggedInStudent.getRollNo());


        System.out.println("-----------------------------------------");
    }

    @Test
    void loginStudentWithAnInvalidEntry() {

        System.out.println("-----------------------------------------");

        var loggedInStudent = studentServiceImpln.loginStudent(5, "pwd1");

        System.out.println(loggedInStudent.toString());

        System.out.println("-----------------------------------------");
    }

    @Test
    void createStudent() {
        System.out.println("-----------------------------------------");
        Student student = new Student();
        student.setName("Bommi");
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
    void updateAnExistingStudent() {
        System.out.println("-----------------------------------------");
        Student student = new Student(2, "Bommi", 25, 30, 35, "pwd");
        StudentDto studentDto = studentServiceImpln.updateStudent(student);
        System.out.println(studentDto);
        System.out.println("-----------------------------------------");
    }

    @Test
    void updateANonExistingStudent() {
        System.out.println("-----------------------------------------");
        Student student = new Student(2000, "Bommi", 25, 30, 35, "pwd");
        StudentDto studentDto = studentServiceImpln.updateStudent(student);
        System.out.println(studentDto);
        System.out.println("-----------------------------------------");
    }

    @Test
    void deleteStudent() {
        System.out.println("------------------------------------------------");
        Integer rollNo = 3;
        studentServiceImpln.deleteStudent(rollNo);
        System.out.println("------------------------------------------------");
    }
}

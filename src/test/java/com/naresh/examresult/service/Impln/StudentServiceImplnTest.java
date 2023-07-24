/* (C)2023 */
package com.naresh.examresult.service.Impln;

import static org.junit.jupiter.api.Assertions.*;

import com.naresh.examresult.exceptions.PasswordNotMatchingException;
import com.naresh.examresult.exceptions.ResourceNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(
        properties = "spring.config.additional-location=classpath:application-test.properties")
class StudentServiceImplnTest {

    @Autowired StudentServiceImpln studentServiceImpln;
    @Autowired ModelMapper modelMapper;

    @Autowired JdbcTemplate jdbcTemplate;

    @BeforeEach
    void clearDataBase() {
        System.out.println("batman");
        System.out.println(System.getenv("DATASOURCE_TEST_URL"));
        String query = "delete from student_table";
        System.out.println(query);
        jdbcTemplate.execute(query);
        // before each testcase this method will run
        // we're going to clear database before running each testcase
    }

    @Test
    void loginStudentWithAValidEntry() {
        System.out.println("batman");
        System.out.println(System.getenv("DATASOURCE_TEST_URL"));

        System.out.println("-----------------------------------------");

        Student student = new Student(5, "Nimmi", 20, 25, 30, "pwd1");

        StudentDto savedStudentDto = studentServiceImpln.createStudent(student);
        StudentDto loggedInStudent =
                studentServiceImpln.loginStudent(
                        savedStudentDto.getRollNo(), student.getPassword());

        System.out.println(loggedInStudent.toString());
        Assertions.assertEquals(savedStudentDto, loggedInStudent);

        System.out.println("-----------------------------------------");
    }

    @Test
    void loginStudentWithAnInvalidRollNo() {

        System.out.println("-----------------------------------------");

        assertThrows(
                ResourceNotFoundException.class,
                () -> {
                    // Code that should throw MyException
                    Student student = new Student(5, "Nimmi", 20, 25, 30, "pwd1");

                    StudentDto savedStudentDto = studentServiceImpln.createStudent(student);
                    StudentDto loggedInStudent =
                            studentServiceImpln.loginStudent(
                                    savedStudentDto.getRollNo() + 10, student.getPassword());

                    System.out.println(loggedInStudent.toString());
                });

        System.out.println("-----------------------------------------");
    }

    @Test
    void loginStudentWithAnInvalidPassword() {

        System.out.println("-----------------------------------------");

        assertThrows(
                PasswordNotMatchingException.class,
                () -> {
                    Student student = new Student(5, "Nimmi", 20, 25, 30, "pwd1");
                    StudentDto createdStudent = studentServiceImpln.createStudent(student);
                    StudentDto loggedInStudent =
                            studentServiceImpln.loginStudent(
                                    createdStudent.getRollNo(), (student.getPassword() + "haga"));
                    System.out.println(loggedInStudent.toString());
                });

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
        Assertions.assertEquals(modelMapper.map(student, StudentDto.class), savedStudentDto);

        System.out.println("-----------------------------------------");
    }

    @Test
    void getStudentByIdIsSuccessForAValidEntry() {
        System.out.println("-----------------------------------------");
        Student createStudent = new Student();
        createStudent.setName("Name");
        createStudent.setScience(20);
        createStudent.setMath(30);
        createStudent.setEnglish(40);
        StudentDto createdStudentDto = studentServiceImpln.createStudent(createStudent);
        Integer rollNo = createdStudentDto.getRollNo();
        StudentDto studentDto = studentServiceImpln.getStudentById(rollNo);
        Assertions.assertEquals(createdStudentDto, studentDto);
        System.out.println("-----------------------------------------");
    }

    @Test
    void getStudentByIdThrowsCustomMadeExceptionWForAnInvalidEntry() {

        assertThrows(
                ResourceNotFoundException.class,
                () -> {
                    Integer rollNo = 7;
                    studentServiceImpln.getStudentById(rollNo);
                });
    }

    @Test
    void getResultIsSuccessForAValidInput() {
        Student student = new Student(10, "Reshma", 34, 34, 36, "pwd");
        StudentDto createdStudentDto = studentServiceImpln.createStudent(student);
        StudentDto result =
                studentServiceImpln.getResult(createdStudentDto.getRollNo(), student.getPassword());
        Assertions.assertEquals(createdStudentDto, result);
    }

    @Test
    void getResultThrowsExceptionWhenGivenWrongPassword() {
        Student student = new Student(10, "Karishma", 34, 34, 36, "pwd");
        StudentDto createdStudentDto = studentServiceImpln.createStudent(student);

        assertThrows(
                PasswordNotMatchingException.class,
                () -> {
                    StudentDto result =
                            studentServiceImpln.getResult(
                                    createdStudentDto.getRollNo(),
                                    student.getPassword() + "fgvdrv");
                });
    }

    @Test
    void getResultThrowsExceptionWhenInvalidRollNumberIsGiven() {
        Student student = new Student(10, "Karishma", 34, 34, 36, "pwd");
        StudentDto createdStudentDto = studentServiceImpln.createStudent(student);

        assertThrows(
                ResourceNotFoundException.class,
                () -> {
                    StudentDto result =
                            studentServiceImpln.getResult(
                                    (100 + createdStudentDto.getRollNo()), student.getPassword());
                });
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

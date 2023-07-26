package com.naresh.examresult.repository;

import com.naresh.examresult.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to insert data into the "student" table
    public void insertStudent(String name, String dateOfBirth) {
        String sql = "INSERT INTO student (name, dob) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, dateOfBirth);
    }


    //Method to insert data into the "result" table
    public void insertResult(String rollNo, String examName, String resultJson) {
        String sql = "INSERT INTO student (roll_number, exam_name,result_json) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, rollNo, examName,resultJson);
    }

    //method to get data from "student" table

    public Student getStudentByRollNumber(int rollNumber) {
        String sql = "SELECT * FROM student WHERE roll_number = ?";
        return (Student) jdbcTemplate.queryForObject(
                sql,
                new Object[]{rollNumber},
                new BeanPropertyRowMapper(Student.class));

    }
}

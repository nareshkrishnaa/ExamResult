package com.naresh.examresult.repository;

import com.google.gson.Gson;
import com.naresh.examresult.model.ResultUpdationPageObject;
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

    public String rupoToJson(ResultUpdationPageObject rupo){
        return new Gson().toJson(rupo);
    }

    public ResultUpdationPageObject jsonToRupo(String jsonString){
        Gson gson=new Gson();
        ResultUpdationPageObject result = gson.fromJson(jsonString, ResultUpdationPageObject.class);
        return result;
    }

//Insert into table
    public void rupoToDB(ResultUpdationPageObject rupo){
        String sql = "INSERT INTO result (roll_number, exam_name, result_json) VALUES (?, ?, ?)";
        try {
            // Use JdbcTemplate to execute the SQL query with placeholders
            String rupoString = "'"+this.rupoToJson(rupo)+"'";
            System.out.println(rupoString);
            jdbcTemplate.update(sql, rupo.getRollNo(), rupo.getNameOftheExamination(), rupoString);
            System.out.println("Data inserted successfully!");
        } catch (Exception e) {
            // Handle any exceptions
            System.err.println("Error inserting data: " + e.getMessage());
        }

    }
}

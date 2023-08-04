package com.naresh.examresult.repository;

import com.naresh.examresult.model.ResultUpdationPageObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    @Autowired
StudentDAO studentDAO;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void rupoToDB() {

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("math",29);
        hm.put("sci",66);
        ResultUpdationPageObject rupo = new ResultUpdationPageObject("hari",20,"sem-1",hm);

        studentDAO.rupoToDB(rupo);

    }

    @Test
    void rupoToJson() {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("math",29);
        hm.put("sci",66);
        ResultUpdationPageObject rupo = new ResultUpdationPageObject("hari",20,"sem-1",hm);
        System.out.println(studentDAO.rupoToJson(rupo));
    }
}
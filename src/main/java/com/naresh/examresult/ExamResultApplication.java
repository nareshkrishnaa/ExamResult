/* (C)2023 */
package com.naresh.examresult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamResultApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamResultApplication.class, args);


        String jsonString = "{\"name\":\"John\",\"rollNo\":123,\"nameOftheExamination\":\"Final Exam\"," +
                "\"subjectMarkList\":{\"Math\":90,\"Science\":85,\"English\":78}}";
        System.out.println(jsonString);
    }
}

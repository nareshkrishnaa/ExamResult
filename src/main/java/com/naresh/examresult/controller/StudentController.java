package com.naresh.examresult.controller;

import com.naresh.examresult.model.Student;
import com.naresh.examresult.model.SubjectMark;
import com.naresh.examresult.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

//this url brings the page where the teacher enters the roll No of the student

    //http://localhost:8080/result-portal
    @GetMapping("result-portal")
    public String resultPortal(){

        return "entering-student-roll-number-page";
    }

    @PostMapping("/result-updation") // Handles POST requests to "/submit" endpoint
    public String checkRollNo(@RequestParam("rollNumber") int rollNumber,Model model) {

        Student student = studentDAO.getStudentByRollNumber(rollNumber);
        System.out.println(student.toString());
        model.addAttribute("rollNo",rollNumber);
        model.addAttribute("name",student.getName());
        model.addAttribute("SubjectMark",new SubjectMark());
        System.out.println("Received Roll Number: " + rollNumber);

        return "result-updation2"; // Redirect to a result page after form submission
    }


    //---------------testing-----------------------//

@PostMapping("/studentMarkSout")
public void test1(@ModelAttribute("studentMark") SubjectMark subjectMark){
    System.out.println(subjectMark.toString());
}
    //http://localhost:8080/add
    @PostMapping("/add")
    public String addStudent() {
        studentDAO.insertStudent("narech","1999-05-02");
        return "Student added successfully!";
    }


    //---------baeldung js---------------------------//

    @RequestMapping(value = "/function-call", method = RequestMethod.GET)
    public String getExampleHTML(Model model) {
        model.addAttribute("totalStudents", 5);
        model.addAttribute("student", new com.naresh.examresult.baeldung.Student(1,"baeldung"));
        return "baeldung";
    }

}

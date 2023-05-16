package com.naresh.ExamResult.repository;

import com.naresh.ExamResult.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {

}

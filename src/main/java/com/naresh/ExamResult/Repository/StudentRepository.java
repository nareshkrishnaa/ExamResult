package com.naresh.ExamResult.Repository;

import com.naresh.ExamResult.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {

}

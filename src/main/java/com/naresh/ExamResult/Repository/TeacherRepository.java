package com.naresh.ExamResult.Repository;

import com.naresh.ExamResult.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,String> {

}

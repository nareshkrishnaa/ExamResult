/* (C)2023 */
package com.naresh.examresult.repository;

import com.naresh.examresult.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {}

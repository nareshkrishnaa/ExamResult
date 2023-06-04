/* (C)2023 */
package com.naresh.examresult.repository;

import com.naresh.examresult.entity.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {}

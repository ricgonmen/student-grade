package com.lindacare.studentgrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lindacare.studentgrade.model.StudentGrade;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, String> {

}

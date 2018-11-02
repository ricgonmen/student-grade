package com.lindacare.studentgrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lindacare.studentgrade.model.StudentGrade;
import com.lindacare.studentgrade.model.StudentGradeKey;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, StudentGradeKey> {

	// List<StudentGrade> findByStudentIdCard(String studentIdCard);
}

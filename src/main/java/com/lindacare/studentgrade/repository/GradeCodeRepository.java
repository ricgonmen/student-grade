package com.lindacare.studentgrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lindacare.studentgrade.model.GradeCode;

public interface GradeCodeRepository extends JpaRepository<GradeCode, String> {

	// List<StudentGrade> findByStudentIdCard(String studentIdCard);
}

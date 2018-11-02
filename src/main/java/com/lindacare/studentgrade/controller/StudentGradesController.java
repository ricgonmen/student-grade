package com.lindacare.studentgrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lindacare.studentgrade.model.StudentGrade;
import com.lindacare.studentgrade.repository.StudentGradeRepository;

@RestController
@RequestMapping("/api/v1/studentgrades")
public class StudentGradesController {
	@Autowired
	private StudentGradeRepository studentGradeRepository; 

	@GetMapping
	public List<StudentGrade> list() {
		return studentGradeRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody StudentGrade studentGrade) {
		studentGradeRepository.save(studentGrade);
	}

	@GetMapping("/{id}")
	public StudentGrade get(@PathVariable("id") String id) {
		return studentGradeRepository.getOne(id);
	}

}

package com.lindacare.studentgrade.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(StudentGradesController.class);
	
	@GetMapping
	public List<StudentGrade> list() {
		logger.debug("############## Metodo list");
		List<StudentGrade> retorno = studentGradeRepository.findAll();
		return retorno;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody StudentGrade studentGrade) {
		logger.debug("############## Metodo create");
		studentGradeRepository.save(studentGrade);
	}
/*
	@GetMapping("/{studentIdCard}")
	public List<StudentGrade> get(@PathVariable("studentIdCard") String studentIdCard) {
		logger.debug("############## Metodo get");
		return studentGradeRepository.findByStudentIdCard(studentIdCard);
	}
*/
}

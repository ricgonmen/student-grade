package com.lindacare.studentgrade.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lindacare.studentgrade.model.StudentGrade;
import com.lindacare.studentgrade.model.StudentGradeKey;
import com.lindacare.studentgrade.model.SubjectCode;
import com.lindacare.studentgrade.model.University;
import com.lindacare.studentgrade.repository.StudentGradeRepository;

@RestController
@RequestMapping("/api/v1/studentgrades")
public class StudentGradesController {
	@Autowired
	private StudentGradeRepository studentGradeRepository;

	Logger logger = LoggerFactory.getLogger(StudentGradesController.class);

	@GetMapping
	public List<StudentGrade> list() {
		logger.info("############## Metodo list");
		List<StudentGrade> retorno = studentGradeRepository.findAll();
		return retorno;
	}


	@PostMapping
	public ResponseEntity<?> create(@RequestBody StudentGrade studentGrade, UriComponentsBuilder ucBuilder) {
		logger.info("############## Create student grade {} ", studentGrade);

		Optional<StudentGrade> studentGradeFind = studentGradeRepository.findById(studentGrade.getKey());
		if (studentGradeFind.isPresent()) {
			logger.error("Unable to create. A student grade with key {} already exist", studentGrade.getKey());
			return new ResponseEntity<String> ("Unable to create. A student grade with key " + studentGrade.getKey() + " already exist.",
					HttpStatus.CONFLICT);
		}
		studentGradeRepository.save(studentGrade);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				ucBuilder.path("/studentIdCard/{studentIdCard}/subjectCode/{subjectCode}/university/{university}")
						.buildAndExpand(studentGrade.getKey().getStudentIdCard(),
								studentGrade.getKey().getSubjectCode(), studentGrade.getKey().getUniversity())
						.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/studentIdCard/{studentIdCard}/subjectCode/{subjectCode}/university/{university}")
	public Optional<StudentGrade> get(@PathVariable("studentIdCard") String studentIdCard,
			@PathVariable("subjectCode") SubjectCode subjectCode, @PathVariable("university") University university) {
		logger.info("############## Metodo get");
		StudentGradeKey studentGradeKey = new StudentGradeKey(studentIdCard, subjectCode, university);
		return studentGradeRepository.findById(studentGradeKey);
	}

}

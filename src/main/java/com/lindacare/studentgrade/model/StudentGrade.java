package com.lindacare.studentgrade.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class StudentGrade {
	
	/* {"studentIdCard": "X23498589F", "subjectCode": "BIO2", "gradeCode": "A", "graduationYear":
2005, "timePlaced": "24-OCT-18 10:27:44", "originatingState" : "NY", "university" : "NYU"}*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String studentIdCard;
	
	@NotBlank
    @Size(min = 4, max = 4)
	private String subjectCode;
	@NotBlank
    @Size(min = 1, max = 1)	
	private String gradeCode;
	@NotBlank
	private Long graduationYear;
	@NotBlank
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "DD-MMM-YY HH:MM:SS")
	private Date timePlaced;
	@NotBlank
	@Size(min = 2, max = 2)
	private String originatingState;
	@NotBlank
	@Size(min = 1)
	private String university;
	
	public String getStudentIdCard() {
		return studentIdCard;
	}
	public void setStudentIdCard(String studentIdCard) {
		this.studentIdCard = studentIdCard;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public Long getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(Long graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getOriginatingState() {
		return originatingState;
	}
	public void setOriginatingState(String originatingState) {
		this.originatingState = originatingState;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public Date getTimePlaced() {
		return timePlaced;
	}
	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}
}

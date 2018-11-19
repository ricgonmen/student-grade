package com.lindacare.studentgrade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class StudentGrade {
	
	@ManyToOne
	@JoinColumn(name = "grade_code", foreignKey = @ForeignKey(name = "fk_grade_code"))
	private GradeCode gradeCode;
	
	@Column(nullable = false)
	private Integer graduationYear;
	
	@EmbeddedId
	private StudentGradeKey key;	
	
	@Enumerated(EnumType.STRING)
	@Column(length=2, nullable = false)
	private OriginatingState originatingState;
	
	@Column(nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MMM-yy HH:mm:ss") 
	private Timestamp timePlaced;
	
	public StudentGrade() {
	}
		
	public StudentGrade(StudentGradeKey key, GradeCode gradeCode, Integer graduationYear, Timestamp timePlaced,
			OriginatingState originatingState) {
		super();
		this.key = key;
		this.gradeCode = gradeCode;
		this.graduationYear = graduationYear;
		this.timePlaced = timePlaced;
		this.originatingState = originatingState;
	}
	
	
	public char getGradeCode() {
		return (gradeCode!=null?gradeCode.getCode():null);
	}
	public Integer getGraduationYear() {
		return graduationYear;
	}
	public OriginatingState getOriginatingState() {
		return originatingState;
	}
	public String getStudentIdCard() {
		return (key!=null?key.getStudentIdCard():null);
	}
	public SubjectCode getSubjectCode() {
		return (key!=null?key.getSubjectCode():null);
	}
	public Timestamp getTimePlaced() {
		return timePlaced;
	}
	public University getUniversity() {
		return (key!=null?key.getUniversity():null);
	}
	public void setGradeCode(char code) {
		if (gradeCode!=null)
			gradeCode.setCode(code);
	}	
	public void setGraduationYear(Integer graduationYear) {
		this.graduationYear = graduationYear;
	}
	public void setOriginatingState(OriginatingState originatingState) {
		this.originatingState = originatingState;
	}
	public void setStudentIdCard(String studentIdCard) {
		if (key!=null)
			key.setStudentIdCard(studentIdCard);
	}
	public void setSubjectCode(SubjectCode subjectCode) {
		if (key!=null)
			key.setSubjectCode(subjectCode);
	}
	public void setTimePlaced(Timestamp timePlaced) {
		this.timePlaced = timePlaced;
	}
	public void setUniversity(University university) {
		if (key!=null)
			key.setUniversity(university);
	}
}

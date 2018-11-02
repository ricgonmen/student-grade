package com.lindacare.studentgrade.model;

import java.sql.Timestamp;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class StudentGrade {
	
	public StudentGrade(StudentGradeKey key, @NotNull @Size(max = 1) String gradeCode, @NotNull Long graduationYear,
			@NotNull Timestamp timePlaced, @NotNull @Size(min = 2, max = 2) String originatingState) {
		super();
		this.key = key;
		this.gradeCode = gradeCode;
		this.graduationYear = graduationYear;
		this.timePlaced = timePlaced;
		this.originatingState = originatingState;
	}
	
	public StudentGrade() {
	}
	
	@EmbeddedId
	private StudentGradeKey key;	
	
	@NotNull
    @Size(max = 1)	
	private String gradeCode;
	
	@NotNull
	private Long graduationYear;
	
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MMM-yy HH:mm:ss") 
	private Timestamp timePlaced;
	
	@NotNull
	@Size(min = 2, max = 2)
	private String originatingState;
	
	
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
	public Timestamp getTimePlaced() {
		return timePlaced;
	}
	public void setTimePlaced(Timestamp timePlaced) {
		this.timePlaced = timePlaced;
	}
	public StudentGradeKey getKey() {
		return key;
	}
	public void setKey(StudentGradeKey key) {
		this.key = key;
	}
}

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
	
	public StudentGrade(@NotNull String studentIdCard, @NotNull @Size(min = 4, max = 4) String subjectCode,
			@NotNull @Size(min = 1) String university, @NotNull @Size(max = 1) String gradeCode, @NotNull Long graduationYear,
			@NotNull Timestamp timePlaced, @NotNull @Size(min = 2, max = 2) String originatingState) {
		super();
		this.key = new StudentGradeKey(studentIdCard,subjectCode,university);
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
	
	public String getStudentIdCard() {
		return (key!=null?key.getStudentIdCard():null);
	}
	public void setStudentIdCard(String studentIdCard) {
		if (key!=null)
			key.setStudentIdCard(studentIdCard);
	}
	public String getSubjectCode() {
		return (key!=null?key.getSubjectCode():null);
	}
	public void setSubjectCode(String subjectCode) {
		if (key!=null)
			key.setSubjectCode(subjectCode);
	}
	public String getUniversity() {
		return (key!=null?key.getUniversity():null);
	}
	public void setUniversity(String university) {
		if (key!=null)
			key.setUniversity(university);
	}
}

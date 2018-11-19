package com.lindacare.studentgrade.model;
// http://www.discoverabroad.com/us/LivingAbroad/Education/GradingSystemInTheUS.htm 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class GradeCode {
	@Id
	@Column(length=1)
	private char code;
	@NotNull
	private Double GPA;
	@NotNull
	private String undergraduate;
	@NotNull
	private String graduate;
	
	/*
	@OneToMany(mappedBy = "gradeCode", cascade = CascadeType.ALL)    
    @JsonIgnore
    private Set<StudentGrade> studentGrades;
    */ 

	public GradeCode() { }

	public GradeCode(char code, Double GPA, String undergraduate, String graduate) {
		this.code = code;
		this.GPA = GPA;
		this.undergraduate = undergraduate;
		this.graduate = graduate;
	}

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}

	public Double getGPA() {
		return this.GPA;
	}

	public void setGPA(Double GPA) {
		this.GPA = GPA;
	}

	public String getUndergraduate() {
		return undergraduate;
	}

	public void setUndergraduate(String undergraduate) {
		this.undergraduate = undergraduate;
	}

	public String getGraduate() {
		return graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

}

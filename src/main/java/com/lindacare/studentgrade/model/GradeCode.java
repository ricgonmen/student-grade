package com.lindacare.studentgrade.model;
/* http://www.discoverabroad.com/us/LivingAbroad/Education/GradingSystemInTheUS.htm 
  	Grade	GPA		Undergraduate 	Graduate 
	A 		4.0 	Excellent		Excellent
	B		3.0		Good			Good/Average
	C		2.0		Average			Passing
	D		1.0		Passing			Failing
	F		0.0		Failing			Failing
*/

public class GradeCode {
	String grade;
	Double GPA;
	String undergraduate;
	String graduate;

	public GradeCode() { }

	public GradeCode(String grade, Double GPA, String undergraduate, String graduate) {
		this.grade = grade;
		this.GPA = GPA;
		this.undergraduate = undergraduate;
		this.graduate = graduate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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

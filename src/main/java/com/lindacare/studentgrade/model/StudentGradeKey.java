package com.lindacare.studentgrade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class StudentGradeKey implements Serializable {

	private static final long serialVersionUID = 6633761191166943852L;

	@Column(nullable = false)
	private String studentIdCard;

	@Enumerated(EnumType.STRING)
	@Column(length = 4, nullable = false)
	private SubjectCode subjectCode;

	@Enumerated(EnumType.STRING)
	@Column(length = 3, nullable = false)
	private University university;

	public StudentGradeKey() {
	}

	public StudentGradeKey(String studentIdCard, SubjectCode subjectCode, University university) {
		super();
		this.studentIdCard = studentIdCard;
		this.subjectCode = subjectCode;
		this.university = university;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		StudentGradeKey that = (StudentGradeKey) o;

		if (!studentIdCard.equals(that.studentIdCard))
			return false;
		else if (!subjectCode.equals(that.subjectCode))
			return false;
		else
			return university.equals(that.university);
	}

	public String getStudentIdCard() {
		return studentIdCard;
	}

	public SubjectCode getSubjectCode() {
		return subjectCode;
	}

	public University getUniversity() {
		return university;
	}

	@Override
	public int hashCode() {
		int result = studentIdCard.hashCode();
		result = 31 * result + subjectCode.hashCode();
		result = 31 * result + university.hashCode();
		return result;
	}
	
	@Override
	public String toString() {
		return "[studentIdCard: '" + studentIdCard + "', subjectCode: '" + subjectCode + "', university: '" + university + "']";	
	}

	public void setStudentIdCard(String studentIdCard) {
		this.studentIdCard = studentIdCard;
	}

	public void setSubjectCode(SubjectCode subjectCode) {
		this.subjectCode = subjectCode;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
}

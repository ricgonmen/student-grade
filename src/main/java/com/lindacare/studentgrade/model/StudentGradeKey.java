package com.lindacare.studentgrade.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class StudentGradeKey implements Serializable {
	
	private static final long serialVersionUID = 6633761191166943852L;


	public StudentGradeKey(@NotNull String studentIdCard, @NotNull @Size(min = 4, max = 4) String subjectCode,
			@NotNull @Size(min = 1) String university) {
		super();
		this.studentIdCard = studentIdCard;
		this.subjectCode = subjectCode;
		this.university = university;
	}
	
	public StudentGradeKey() {
	}

	@NotNull
	private String studentIdCard;	
	@NotNull
    @Size(min = 4, max = 4)
	private String subjectCode;
	@NotNull
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
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentGradeKey that = (StudentGradeKey) o;

        if (!studentIdCard.equals(that.studentIdCard)) 
        	return false;
        else if (!subjectCode.equals(that.subjectCode)) 
        	return false;
        else 
        	return university.equals(that.university);
    }

    @Override
    public int hashCode() {
        int result = studentIdCard.hashCode();
        result = 31 * result + subjectCode.hashCode();
        result = 31 * result + university.hashCode();
        return result;
    }
}

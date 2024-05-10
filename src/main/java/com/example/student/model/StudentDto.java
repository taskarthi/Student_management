package com.example.student.model;

import java.util.Date;

public class StudentDto {
	
    private Integer id;
	
	
    private String name;

	
    private Date dateOfBirth;

	
    private Date joinningDate;

	
    private String studentClass;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Date getJoinningDate() {
		return joinningDate;
	}


	public void setJoinningDate(Date joinningDate) {
		this.joinningDate = joinningDate;
	}


	public String getStudentClass() {
		return studentClass;
	}


	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
    
}

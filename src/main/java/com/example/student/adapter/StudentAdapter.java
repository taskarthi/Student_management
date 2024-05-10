package com.example.student.adpater;

import org.springframework.stereotype.Component;

import com.example.student.entity.Student;
import com.example.student.model.StudentDto;
@Component
public class StudentAdapter {

	public StudentDto convertEntityTosPojo(Student studentPersitedEntity) {
		StudentDto studentRes = new StudentDto();
		studentRes.setId(studentPersitedEntity.getId());
		studentRes.setName(studentPersitedEntity.getName());
		studentRes.setStudentClass(studentPersitedEntity.getStudentClass());
		studentRes.setDateOfBirth(studentPersitedEntity.getDateOfBirth());
		studentRes.setJoinningDate(studentPersitedEntity.getJoinningDate());
		return studentRes;
	}
	public Student convertPojoToEntity(StudentDto studentPayload) {
		Student studentEntity= new Student();
		studentEntity.setId(studentPayload.getId());
		studentEntity.setName(studentPayload.getName());
		studentEntity.setStudentClass(studentPayload.getStudentClass());
		studentEntity.setDateOfBirth(studentPayload.getDateOfBirth());
		studentEntity.setJoinningDate(studentPayload.getJoinningDate());
		return studentEntity;
	}
}

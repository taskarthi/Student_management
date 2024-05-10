package com.example.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.adpater.StudentAdapter;
import com.example.student.entity.Student;
import com.example.student.model.StudentDto;
import com.example.student.repository.StudentsRepository;

@Service
public class StudentService {

	@Autowired
	private StudentsRepository studentRepo;
	@Autowired

	private StudentAdapter adapter;

	public List<StudentDto> getStudentDetailsByIdOrNameOrClass(Integer id, String name, String studentClass) {

		List<Student> students = studentRepo.findByIdOrNameOrStudentClass(id, name, studentClass);
		List<StudentDto> listOfStudents = new ArrayList<>();
		for (Student st : students) {
			listOfStudents.add(adapter.convertEntityTosPojo(st));
		}
		return listOfStudents;
	}

	public StudentDto registerStudent(StudentDto studentDto) {

		Student student = adapter.convertPojoToEntity(studentDto);
		if (Optional.ofNullable(student).isPresent()) {
			Student studentPersitedEntity = studentRepo.save(student);

			return adapter.convertEntityTosPojo(studentPersitedEntity);

		}

		return new StudentDto();
	}

	public StudentDto updateStudent(Integer id, StudentDto studentPayload) {
		Optional<Student> studentEntity=studentRepo.findById(id);
		
		if (Optional.ofNullable(studentEntity).isPresent()) {
			
			if(studentPayload.getId() != null) {
				studentEntity.get().setId(studentPayload.getId());
			}
			if(studentPayload.getName() != null) {
				studentEntity.get().setName(studentPayload.getName());
			}
			if(studentPayload.getStudentClass() != null) {
				studentEntity.get().setStudentClass(studentPayload.getStudentClass());
			}
			if(studentPayload.getDateOfBirth() != null) {
				studentEntity.get().setDateOfBirth(studentPayload.getDateOfBirth());
			}
			if(studentPayload.getJoinningDate() != null) {
				studentEntity.get().setJoinningDate(studentPayload.getJoinningDate());
			}
			
			return adapter.convertEntityTosPojo(studentRepo.save(studentEntity.get()));
		}
		
		return null;
	}

}

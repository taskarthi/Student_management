package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.StudentDto;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("api/v1")
public class StudentController {

	@Autowired
	private StudentService studentsService;

	@PostMapping("/student")
	public ResponseEntity<StudentDto> registerStudentInfo(@RequestBody StudentDto student) {

		try {
			return ResponseEntity.ok(studentsService.registerStudent(student));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(student);
		}

	}

	@PutMapping("/student/updateStudent")
	public ResponseEntity<StudentDto> updateStudentInfo(@RequestParam Integer id, @RequestBody StudentDto student) {

		try {
			return new ResponseEntity<StudentDto>(studentsService.updateStudent(id, student), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<StudentDto>(student, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/student/getStudent")
	public ResponseEntity<List<StudentDto>> getStudentDetailsByIdOrNameOrClass(@RequestBody StudentDto student) {
		List<StudentDto> studentDetails = null;

		try {
			studentDetails = studentsService.getStudentDetailsByIdOrNameOrClass(student.getId(), student.getName(),
					student.getStudentClass());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentDetails != null ? ResponseEntity.ok(studentDetails) : ResponseEntity.notFound().build();
	}
}

package com.example.student.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Integer>{

	
	List<Student> findByIdOrNameOrStudentClass(Integer id, String name, String studentClass);
}
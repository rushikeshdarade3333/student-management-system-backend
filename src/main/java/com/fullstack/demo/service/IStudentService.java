package com.fullstack.demo.service;

import java.util.List;

import com.fullstack.demo.model.Student;

public interface IStudentService {

	Student addStudent(Student student);
	List<Student> getStudents();
	Student getStudentById(Long id);
	Student updateStudent(Student student,Long id);
	void delelteStudent(Long id);
}

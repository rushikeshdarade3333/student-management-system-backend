package com.fullstack.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fullstack.demo.exception.StudentAlreadyExsistsException;
import com.fullstack.demo.exception.StudentNotFoundException;
import com.fullstack.demo.model.Student;
import com.fullstack.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{

	private final StudentRepository studentRepository; 
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentAlreadyExsists(student.getEmail())){
			throw new StudentAlreadyExsistsException(student.getEmail()+" already exsists");
		}
		return studentRepository.save(student);
	}

	private boolean studentAlreadyExsists(String email) {
		// TODO Auto-generated method stub
		return this.studentRepository.findByEmail(email).isPresent();
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id)
				           .orElseThrow(()-> new StudentNotFoundException("Sorry,student not found with this id: "+ id));
		
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).map(st ->{
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setDepartment(student.getDepartment());
			return studentRepository.save(st);
		}).orElseThrow(()-> new StudentNotFoundException("Sorry, this student could not be found"));
	}
	

	@Override
	public void delelteStudent(Long id) {
		// TODO Auto-generated method stub
		if(!studentRepository.existsById(id)) {
			 new StudentNotFoundException("Sorry, student not found");
		}
		studentRepository.deleteById(id);
		
	}

}

package com.StudentDetails.StudentDetails;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {

	@Autowired
	public StudentRepo student;

	public Student saveStudent(Student s) {
		return student.save(s);
		
		}

	public Optional<Student> findById(long id) {
		return student.findById(id);
	}
	
	public Student saveByStudId(long id, Student s) {
		s = student.getOne(id);
		return student.save(s);
	}

	public Map<String, Student> findAll() {
		List<Student> studentList = student.findAll();
		
		return studentList.stream().filter(s -> s.getGpa() >= 3.5)
				.collect(Collectors.toMap(Student::getName, Function.identity()));
	}

	public void deleteById(long id) {
		 student.deleteById(id);
		
	}

}

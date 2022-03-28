package com.StudentDetails.StudentDetails;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	public StudentServiceImpl studentService;

	@GetMapping("/studentBy/{id}")
	public ResponseEntity<Student>getStudent(@PathVariable("id") long id) {
		Optional<Student> studentData = studentService.findById(id);
		if (studentData.isPresent()) {
			Student _student = studentData.get();
			return new ResponseEntity<>(_student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/studentByGPA")
	public ResponseEntity<Map<String , Student>>getStudentBasdOnGPA() {
		Map<String , Student> studentMap= studentService.findAll();
		return new ResponseEntity<>(studentMap, HttpStatus.OK);
//		if (studentMap.isPresent()) {
//			Student _student = studentData.get();
//			
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
	}

	@PostMapping("/createStudent")
	public ResponseEntity<Student> createTutorial(@RequestBody Student student) {
		try {
			Student _student = studentService.saveStudent(student);
			return new ResponseEntity<>(_student, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		
		Optional<Student> studentData = studentService.findById(id);
		if (studentData.isPresent()) {
			Student _student = studentData.get();
			_student.setName(student.getName());
			_student.setGender(student.getGender());
			_student.setGpa(student.getGpa());
			_student.setGradeLevel(student.getGradeLevel());
			return new ResponseEntity<>(studentService.saveStudent(_student), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
		try {
			studentService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}

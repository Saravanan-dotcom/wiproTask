package com.Producer.StudentSportsSubscription;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/student")
public class StudentSportsActionController {
	
	@Autowired
	public StudentSportsRepo studentSportsRepo;
	
	
	@PostMapping("/createStudent")
	public ResponseEntity<StudentSport> createTutorial(@RequestBody StudentSport studentSport) {
		try {
			studentSport = studentSportsRepo.save(studentSport);
			return new ResponseEntity<>(studentSport, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/createStudent/{id}")
	public ResponseEntity<Optional<StudentSport>> getStudentById(@PathVariable("id") long id) {
		try {
			Optional<StudentSport> studentSport = studentSportsRepo.findById(id);
			return new ResponseEntity<>(studentSport, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/createStudent")
	public ResponseEntity<List<StudentSport>> getStudentAll() {
		try {
			List<StudentSport> studentSport = studentSportsRepo.findAll();
			return new ResponseEntity<>(studentSport, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
		try {
			 studentSportsRepo.deleteById(id);
			return new ResponseEntity<>("Student Deleted Successfull", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

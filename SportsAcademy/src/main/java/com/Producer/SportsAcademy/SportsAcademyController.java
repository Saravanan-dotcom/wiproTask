package com.Producer.SportsAcademy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SportsAcademyController {
	
	@Autowired
	public SportsAcademyServiceImpl sportsAcademyService;
	
	@Autowired
	public StudentSportServiceImpl studentSportService;

	@GetMapping("/sports")
	public ResponseEntity<List<Sports>>getSports() {
		List<Sports> sportsData  = sportsAcademyService.findAll();
		if (sportsData.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(sportsData, HttpStatus.OK);
		}
	}
	
	@PostMapping("/createSports")
	public ResponseEntity<Sports> createTutorial(@RequestBody Sports sports) {
		try {
			Sports _sports = sportsAcademyService.saveStudent(sports);
			return new ResponseEntity<>(_sports, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/createStudentSport/subscribe")
	public ResponseEntity<StudentSport> createStudentSport(@RequestBody StudentSport stdSports) {
		try {
			StudentSport _stdSports = studentSportService.saveStudentSport(stdSports);
			return new ResponseEntity<>(_stdSports, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}

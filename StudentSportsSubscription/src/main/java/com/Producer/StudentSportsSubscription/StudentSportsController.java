package com.Producer.StudentSportsSubscription;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentSportsController {

	
	@Autowired
    private RabbitTemplate template;
	@Autowired
	public StudentSportsServiceImpl studentSportsService;
	
	
//	@GetMapping("/test")
//	public ResponseEntity<String> createTutorial() {
//		try {
//			String test = "Hello";
//			StudentSport studentSport = new StudentSport("Str1",1);
//			template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, studentSport);
//			return new ResponseEntity<>(test, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	@PostMapping("/createStudentSports")
	public ResponseEntity<StudentSport> createTutorial(@RequestBody StudentSport studentSport) {
		try {
			template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, studentSport);
			return new ResponseEntity<>(studentSport, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

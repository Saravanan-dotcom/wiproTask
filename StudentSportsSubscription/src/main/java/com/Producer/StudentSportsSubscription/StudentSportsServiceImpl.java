package com.Producer.StudentSportsSubscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentSportsServiceImpl {

	@Autowired
	public RestTemplate restTemplate;

	public StudentSport saveStudent(StudentSport studentSport) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<StudentSport> httpEntity = new HttpEntity<StudentSport>(studentSport, headers);
		ResponseEntity<StudentSport> exchange = restTemplate.exchange(
				"http://localhost:9001/api/createStudentSport/subscribe", HttpMethod.POST, httpEntity,
				StudentSport.class);
		StudentSport body = exchange.getBody();

		return body;
	}

}

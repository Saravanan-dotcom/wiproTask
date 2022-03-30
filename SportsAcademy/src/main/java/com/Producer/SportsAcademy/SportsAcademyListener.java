package com.Producer.SportsAcademy;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SportsAcademyListener {
	
	@Autowired
	public StudentSportServiceImpl studentSportService;
	
	 @RabbitListener(queues = MessagingConfig.QUEUE)
	    public void consumeMessageFromQueue(StudentSport studentSport) {
	        System.out.println("Message recieved from queue : " + studentSport);
	        studentSportService.saveStudentSport(studentSport);
	    }

}

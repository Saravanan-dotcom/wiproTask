package com.Producer.SportsAcademy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSportServiceImpl {
	
	

	@Autowired
	public StudentSportRepo studentSportRepo;

	public StudentSport saveStudentSport(StudentSport stdSports) {
		return studentSportRepo.save(stdSports);
	}

}

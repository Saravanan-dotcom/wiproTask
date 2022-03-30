package com.Producer.SportsAcademy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsAcademyServiceImpl {

	@Autowired
	public SportsAcademyRepo sportsAcademyRepo;
	public List<Sports> findAll() {
		return sportsAcademyRepo.findAll();
	}
	public Sports saveStudent(Sports sports) {
		// TODO Auto-generated method stub
		return sportsAcademyRepo.save(sports);
	}

}

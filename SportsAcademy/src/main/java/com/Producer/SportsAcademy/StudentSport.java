package com.Producer.SportsAcademy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentSportSubscription")
public class StudentSport {
	
	
	@Id
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "sportId")
	private long sportId;
	
  public StudentSport() {
		
	}
	
	public StudentSport(long id ,String name,long sportId) {
		super();
		this.id = id;
		this.name = name;
		this.sportId = sportId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSportId() {
		return sportId;
	}

	public void setSportId(long sportId) {
		this.sportId = sportId;
	}
	
	

	

}

package com.Producer.SportsAcademy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSportRepo extends JpaRepository<StudentSport, Long> {
}

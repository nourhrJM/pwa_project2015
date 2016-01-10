package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Candidat;

public interface CandidatRepo extends JpaRepository<Candidat, Long> {

	Candidat findByLoginAndPassword(String login, String password);

}

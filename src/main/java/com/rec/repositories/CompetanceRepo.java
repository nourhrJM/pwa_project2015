package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Competence;

public interface CompetanceRepo extends JpaRepository<Competence, Long> {

	Competence findByIntitule(String intitule);
}

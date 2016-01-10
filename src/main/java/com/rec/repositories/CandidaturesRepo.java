package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Candidature;
import com.rec.models.Offre;

public interface CandidaturesRepo extends JpaRepository<Candidature, Long> {

	Candidature findByOffre(Offre off);

}
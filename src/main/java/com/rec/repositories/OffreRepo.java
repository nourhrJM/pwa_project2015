package com.rec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Annonceur;
import com.rec.models.Offre;

public interface OffreRepo extends JpaRepository<Offre, Long> {
	List<Offre> findByAnnonceur(Annonceur a);

	Offre findByintitule(String intitule);
}

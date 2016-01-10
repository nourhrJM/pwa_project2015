package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Annonceur;

public interface AnnonceurRepo extends JpaRepository<Annonceur, Long> {

	Annonceur findByLoginAndPassword(String login, String password);

	Annonceur findById(Long id);

}

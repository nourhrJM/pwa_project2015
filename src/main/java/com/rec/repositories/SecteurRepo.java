package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Secteur;

public interface SecteurRepo extends JpaRepository<Secteur, Long> {

	Secteur findById(Long id);
}

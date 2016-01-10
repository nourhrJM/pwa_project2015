package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Etat;

public interface EtatRepo extends JpaRepository<Etat, Long> {

}

package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Contrat;

public interface ContratRepo extends JpaRepository<Contrat, Long> {

}

package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Salaire;

public interface SalaireRepo extends JpaRepository<Salaire, Long> {

}

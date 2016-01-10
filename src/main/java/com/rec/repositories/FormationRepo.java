package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Formation;

public interface FormationRepo extends JpaRepository<Formation, Long> {

	public Formation findBycandidat_id(String id);

}

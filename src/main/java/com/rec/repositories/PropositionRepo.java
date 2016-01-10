package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Proposition;

public interface PropositionRepo extends JpaRepository<Proposition, Long> {

}

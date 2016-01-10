package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.SituationFamiliale;

public interface SituationFamRepo extends JpaRepository<SituationFamiliale, Long> {

}

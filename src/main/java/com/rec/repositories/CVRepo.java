package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.CV;

public interface CVRepo extends JpaRepository<CV, Long> {

}

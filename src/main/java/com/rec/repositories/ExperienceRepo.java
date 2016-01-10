package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Experience;

public interface ExperienceRepo extends JpaRepository<Experience, Long> {

}
